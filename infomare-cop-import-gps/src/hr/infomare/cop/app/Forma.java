
package hr.infomare.cop.app;

import hr.infomare.cop.db.Doprinos;
import hr.infomare.cop.db.Obracun;
import hr.infomare.cop.db.Obustava;
import hr.infomare.cop.db.Olaksica;
import hr.infomare.cop.db.Param;
import hr.infomare.cop.db.Poduzece;
import hr.infomare.cop.db.Poripri;
import hr.infomare.cop.db.Prihod;
import hr.infomare.cop.db.Zaposl;
import hr.infomare.cop.db.Zaprac;
import hr.infomare.cop.db.ZapracPK;
import hr.infomare.cop.jaxb.BrutoType;
import hr.infomare.cop.jaxb.DoprinosIzType;
import hr.infomare.cop.jaxb.DoprinosNaType;
import hr.infomare.cop.jaxb.InstitucijaType;
import hr.infomare.cop.jaxb.NeoporeziviPrihodiType;
import hr.infomare.cop.jaxb.ObustaveType;
import hr.infomare.cop.jaxb.OlaksiceType;
import hr.infomare.cop.jaxb.OpObrasci;
import hr.infomare.cop.jaxb.ParametriObracunaType;
import hr.infomare.cop.jaxb.PorezPrirezType;
import hr.infomare.cop.jaxb.ZaposlenikType;
import hr.infomare.cop.opci.FileDrop;

import hr.infomare.cop.opci.Pomocna;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ComponentAdapter;

import java.awt.event.ComponentEvent;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;



import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Collection;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.table.TableCellRenderer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author ivanj
 */
public class Forma extends javax.swing.JPanel {
    
    public String xmlDatoteka;
    Integer status;
    String oldID;
    
    Task t;  // thread za import podataka i azuriranje progressbara i tablice
    
    public int brojZapisa() throws JAXBException {
        
        JAXBContext jc = JAXBContext.newInstance(OpObrasci.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
        OpObrasci obrasci= (OpObrasci)
           unmarshaller.unmarshal(new File(xmlDatoteka));
        
        List<ZaposlenikType> listaZaposlenika= obrasci.getZaposlenik();
        
        return listaZaposlenika.size();
    }
    
    
    class Task extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground()  {            
            EntityManagerFactory emf;
            EntityManager em = null;
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            Integer iduciId=null;  //iduci id obracuna
            int iduciRbr=0;   //iduci Rbr
            
         try {
             
             
             
                emf = Persistence.createEntityManagerFactory("infomare-cop-import-klijent", Pomocna.getPersistenceProps());
                em = emf.createEntityManager();
             
                em.getTransaction().begin();
             
             
             
             
             
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    
             if(status==10) {
                 iduciId=Integer.valueOf(oldID);
                    em.createQuery("delete from Olaksica p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Doprinos p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Obustava p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Zaprac p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Prihod p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Poripri p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Param p where p.obrid="+Integer.toString(iduciId)).executeUpdate();                                                            
                    em.createQuery("delete from Zaposl p where p.obrid="+Integer.toString(iduciId)).executeUpdate();
                    em.createQuery("delete from Poduzece p where p.obrid="+Integer.toString(iduciId)).executeUpdate();                    
                    em.createQuery("delete from Obracun p where p.obrid="+Integer.toString(iduciId)).executeUpdate();                    

                } else {
                    //pronadji iduci ID obracuna
                    iduciId = em.createQuery("select max(O.obrid) FROM Obracun O", Integer.class).getSingleResult();
                    if (iduciId==null) iduciId=0;
                    iduciId=iduciId+1;
                }
                
                //System.out.println(Integer.toString(iduciId));
                // �itanje xml-a i insert podataka

                System.out.println("pocetak");
                
                
                
                
                JAXBContext jc = JAXBContext.newInstance(OpObrasci.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                
                OpObrasci obrasci= (OpObrasci)
                   unmarshaller.unmarshal(new File(xmlDatoteka));
                
                
                Obracun obracun = new Obracun();
                obracun.setObrid(iduciId);
                obracun.setK50god(null);
                obracun.setK50nal(null);
                obracun.setStatus(10);
                em.persist(obracun);
                em.flush();
                
                
              InstitucijaType xmlPoslodavac = obrasci.getPoslodavac();
                
                Poduzece poduzece = new Poduzece();
                poduzece.setObrid(iduciId);
                poduzece.setOib(xmlPoslodavac.getOib());
                poduzece.setNaziv(xmlPoslodavac.getNaziv());
                poduzece.setAdresa(xmlPoslodavac.getAdresa());
                poduzece.setPeriodod(df.parse(xmlPoslodavac.getRazdobljePocetak()));
                poduzece.setPerioddo(df.parse(xmlPoslodavac.getRazdobljeZavrsetak()));
                poduzece.setFondsati(xmlPoslodavac.getMjBrSati());                
                /**
                  *     Od verzije 0.6 datum obra�una je neobavezno polje.
                * */
                //poduzece.setDatumobr(df.parse(xmlPoslodavac.getDatumObracuna()));
                poduzece.setDatumobr(df.parse(xmlPoslodavac.getDatumObracuna() == null ?
                                              xmlPoslodavac.getRazdobljeZavrsetak() :
                                              xmlPoslodavac.getDatumObracuna()));
                if(xmlPoslodavac.isIsplata())
                      poduzece.setIsplata("1"); // 1- da
                else poduzece.setIsplata("0");  // 0- ne
                poduzece.setRacunisp(xmlPoslodavac.getBrRacInst());
                
                em.persist(poduzece);
                em.flush();
                
                
                
                List<ZaposlenikType> listaZaposlenika= obrasci.getZaposlenik();
                
                iduciRbr=0;
                for(ZaposlenikType xmlZaposlenik : listaZaposlenika){
                    
                                 jProgressBar1.setValue(iduciRbr+1);
                                 jProgressBar1.repaint();
                                    
                                   System.out.println(xmlZaposlenik.getIme()+" "+xmlZaposlenik.getPrezime());
                    
                                    model = (DefaultTableModel) jTable1.getModel();
                                    model.addRow(new Object[]{Integer.toString(iduciRbr+1)+"/"+Integer.toString(listaZaposlenika.size()), xmlZaposlenik.getOib(), xmlZaposlenik.getPrezime(),xmlZaposlenik.getIme()});
                                 //   jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, 0, true));
                                
                               iduciRbr++;
                                //pronadji iduci Rbr  ovo se moze optimizirati da koristi brojac iz petlje pa
                                // ce se ustedjeti na puno upita
                    
                    /*
                                Integer iduciRbr = em.createQuery("select max(Z.rbr) FROM Zaposl Z where Z.obrid="+Integer.toString(iduciId), Integer.class).getSingleResult();
                                if (iduciRbr==null) iduciRbr=0;
                                iduciRbr=iduciRbr+1;
                    */
                                
                                 Zaposl zaposl= new Zaposl();
                                 zaposl.setObrid(iduciId);
                                 zaposl.setRbr(iduciRbr);
                                 zaposl.setOib(xmlZaposlenik.getOib());
                                 zaposl.setIme(xmlZaposlenik.getIme());
                                 zaposl.setPrezime(xmlZaposlenik.getPrezime());
                                 zaposl.setAdresa(xmlZaposlenik.getAdresa());
                                 zaposl.setInternauj(xmlZaposlenik.getInternaOznakaUJ());
                                 zaposl.setNazivoj(xmlZaposlenik.getNazivUJ());
                                
                                try{
                                    zaposl.setDatumisp(df.parse(xmlZaposlenik.getDatumIsplate()));
                                }catch(Exception ex){
                                    zaposl.setDatumisp(null);        
                                        
                                }
                                 zaposl.setBruto(xmlZaposlenik.getBruto().getUkIznos());
                                 zaposl.setDopriz(xmlZaposlenik.getDoprinosIzPlace().getUkIznos());
                                 zaposl.setDohodak(xmlZaposlenik.getDohodak());
                                 zaposl.setOlaksica(xmlZaposlenik.getOlaksice().getUkIznos());
                                 zaposl.setPorezosn(xmlZaposlenik.getPoreznaOsnovica());
                                 zaposl.setPoripri(xmlZaposlenik.getPorezNaDohodakIPrirez().getUkIznos());
                                 zaposl.setNeto(xmlZaposlenik.getNeto());
                                 zaposl.setNeoporez(xmlZaposlenik.getNeoporeziviPrihodi().getUkIznos());
                                 zaposl.setPrimanja(xmlZaposlenik.getUkPrimanja());               // ovo ok?
                                 zaposl.setObustave(xmlZaposlenik.getObustave().getUkIznos());
                                 zaposl.setIsplata(xmlZaposlenik.getIznosZaisplatu());
                                 zaposl.setTrosakpl(xmlZaposlenik.getUkTrosakPlace());
                                 zaposl.setIsplrazl(xmlZaposlenik.getIznosZaIsplatuRazlika());
                                 em.persist(zaposl);
                                 em.flush();
                    
                    
                    
                                ZaposlenikType.Obustave xmlZaplObustave = xmlZaposlenik.getObustave();
                    
                                List<ObustaveType> listaObustava = xmlZaplObustave.getElementObustave();
                                for(int i=0;i<listaObustava.size();i++){
                                    Obustava obustava = new Obustava();
                                    obustava.setObrid(iduciId);
                                    obustava.setRbr(iduciRbr);
                                    obustava.setStv(i+1);
                                    obustava.setObustava(listaObustava.get(i).getElementPlace().getVrPrihoda());
                                    obustava.setNaziv(listaObustava.get(i).getElementPlace().getNaziv());
                                    obustava.setOpis(listaObustava.get(i).getOpisObustave());
                                    obustava.setSaldo(listaObustava.get(i).getSaldo());
                                    obustava.setPosto(listaObustava.get(i).getPostotak());
                                    obustava.setOstrata(listaObustava.get(i).getBrPreostalihRata());
                                    obustava.setIznos(listaObustava.get(i).getIznos());
                                    obustava.setVjerovnik(listaObustava.get(i).getNazVjerovnika());
                                    
                                    em.persist(obustava);
                                    em.flush();
                                }
                    
                    
                                ZaposlenikType.PorezNaDohodakIPrirez xmlZaplPorPri = xmlZaposlenik.getPorezNaDohodakIPrirez();
                                List<PorezPrirezType> listaPorPri = xmlZaplPorPri.getElementPorezPrirez();
                                for(int i=0;i<listaPorPri.size();i++){
                                    Poripri poripri = new Poripri();
                                    poripri.setObrid(iduciId);
                                    poripri.setRbr(iduciRbr);
                                    poripri.setStv(i+1);
                                    poripri.setPorilipri(listaPorPri.get(i).getElementPlace().getVrPrihoda());
                                    
                                    if(listaPorPri.get(i).getElementPlace().getNaziv().toLowerCase().contains("prirez"))
                                    poripri.setPrirez("1");     // 1 - prirez
                                    else poripri.setPrirez("0");   // 0 - porez
                                    
                                    /*
                                     * gornju kolonu po nazivu filtrirati 1 ako je prirez
                                     * 0 ako je porez
                                     * */
                                    poripri.setNaziv(listaPorPri.get(i).getElementPlace().getNaziv());
                                    poripri.setStopa(listaPorPri.get(i).getStopa());
                                    poripri.setOsnovica(listaPorPri.get(i).getOsnovica());
                                    poripri.setIznos(listaPorPri.get(i).getIznos());
                                    
                                    em.persist(poripri);
                                    em.flush();
                                }
                    
                    
                                ZaposlenikType.Olaksice xmlZaplOlaksice = xmlZaposlenik.getOlaksice();
                                List<OlaksiceType> listaOlaksica = xmlZaplOlaksice.getElementOlaksice();
                    
                                for(int i = 0;i<listaOlaksica.size();i++){
                                    Olaksica olaksica = new Olaksica();
                                    olaksica.setObrid(iduciId);
                                    olaksica.setRbr(iduciRbr);
                                    olaksica.setStv(i+1);
                                    olaksica.setOlaksica(listaOlaksica.get(i).getElementPlace().getVrPrihoda());
                                    olaksica.setNaziv(listaOlaksica.get(i).getElementPlace().getNaziv());
                                    olaksica.setKoeficijent(listaOlaksica.get(i).getKoeficijent());
                                    olaksica.setIznos(listaOlaksica.get(i).getIznos());
                                    
                                    em.persist(olaksica);
                                    em.flush();
                                }
                                
                                
                                int brojacDoprinosa=1;
                                ZaposlenikType.DoprinosIzPlace xmlZaplDoprinosiIz = xmlZaposlenik.getDoprinosIzPlace();
                                List<DoprinosIzType> listaDoprinosiIz = xmlZaplDoprinosiIz.getElementDoprinosIz();
                                for(int i=0;i<listaDoprinosiIz.size();i++){
                                    Doprinos doprinos = new Doprinos();
                                    doprinos.setObrid(iduciId);
                                    doprinos.setRbr(iduciRbr);
                                    doprinos.setStv(brojacDoprinosa++);
                                    doprinos.setDoprinos(listaDoprinosiIz.get(i).getElementPlace().getVrPrihoda());
                                    doprinos.setNaziv(listaDoprinosiIz.get(i).getElementPlace().getNaziv());
                                    doprinos.setPrimjena("1");  // 1 - doprinosi iz
                                    doprinos.setStopa(listaDoprinosiIz.get(i).getStopa());
                                    doprinos.setIznos(listaDoprinosiIz.get(i).getIznos());
                                    em.persist(doprinos);
                                    em.flush();
                                    
                                }
                                
                                ZaposlenikType.DoprinosNaPlacu xmlZaplDoprinosiNa = xmlZaposlenik.getDoprinosNaPlacu();
                                List<DoprinosNaType> listaDoprinosiNa = xmlZaplDoprinosiNa.getElementDoprinosNa();
                                for(int i=0;i<listaDoprinosiNa.size();i++){
                                    Doprinos doprinos = new Doprinos();
                                    doprinos.setObrid(iduciId);
                                    doprinos.setRbr(iduciRbr);
                                    doprinos.setStv(brojacDoprinosa++);
                                    doprinos.setDoprinos(listaDoprinosiNa.get(i).getElementPlace().getVrPrihoda());
                                    doprinos.setNaziv(listaDoprinosiNa.get(i).getElementPlace().getNaziv());
                                    doprinos.setPrimjena("2");  // 2 - doprinosi na
                                    doprinos.setStopa(listaDoprinosiNa.get(i).getStopa());
                                    doprinos.setIznos(listaDoprinosiNa.get(i).getIznos());
                                    em.persist(doprinos);
                                    em.flush();
                                }
                                    
                                
                                ZaposlenikType.NeoporeziviPrihodi xmlZaplNeoPrih =  xmlZaposlenik.getNeoporeziviPrihodi();
                                List<NeoporeziviPrihodiType> listaNeoPrih = xmlZaplNeoPrih.getElementNeoporezPrih();

                    int brPrihoda=0;
                    if (listaNeoPrih.size() != 0) {
                        for (int i = 0; i < listaNeoPrih.size(); i++) {
                            Prihod prihod = new Prihod();
                            prihod.setObrid(iduciId);
                            prihod.setRbr(iduciRbr);
                            prihod.setStv(i + 1);
                            prihod.setPrihod(listaNeoPrih.get(i).getElementPlace().getVrPrihoda());
                            prihod.setNaziv(listaNeoPrih.get(i).getElementPlace().getNaziv());
                            prihod.setNeoporez("1"); // 1 - neoporezivi primitak ,0 - bruto
                            prihod.setInternauj(null);
                            prihod.setNazivuj(null);
                            prihod.setSati(listaNeoPrih.get(i).getBrSati());
                            prihod.setKoef(null);
                            prihod.setOsnovica(null);
                            prihod.setIznos(listaNeoPrih.get(i).getIznos());

                            em.persist(prihod);
                            em.flush();
                            brPrihoda++;
                        }
                    } else {
                    }

                    ZaposlenikType.Bruto xmlZaplBruto = xmlZaposlenik.getBruto();
                                List<BrutoType> listaBruto = xmlZaplBruto.getElementBrutoPlace();
                    
                                if(listaBruto.size()!=0)
                                for(int i=0;i<listaBruto.size();i++){
                                    Prihod prihod = new Prihod();
                                    prihod.setObrid(iduciId);
                                    prihod.setRbr(iduciRbr);
                                    prihod.setStv(brPrihoda+i+1);
                                    prihod.setPrihod(listaBruto.get(i).getElementPlace().getVrPrihoda());
                                    prihod.setNaziv(listaBruto.get(i).getElementPlace().getNaziv());
                                    prihod.setNeoporez("0");   // 0- bruto
                                    prihod.setInternauj(listaBruto.get(i).getInternaOznakaUJ());
                                    prihod.setNazivuj(listaBruto.get(i).getNazivUJ());
                                    prihod.setSati(listaBruto.get(i).getBrSati());
                                    prihod.setKoef(listaBruto.get(i).getKoeficijent());
                                    prihod.setOsnovica(listaBruto.get(i).getOsnovica());
                                    prihod.setIznos(listaBruto.get(i).getIznos());
                                    
                                    em.persist(prihod);
                                    em.flush();
                                }
                    
                    
                                int brojacParam=1;
                                List<ParametriObracunaType> listaParametara = xmlZaposlenik.getParametriObracuna();
                                for(int i=0;i<listaParametara.size();i++){
                                    
                                    List<ParametriObracunaType.Period> listaPeriod =  listaParametara.get(i).getPeriod();
                                    
                                    for(int j=0; j<listaPeriod.size();j++){
                                        
                                    Param param = new Param();
                                    param.setObrid(iduciId);
                                    param.setRbr(iduciRbr);
                                    param.setStv(brojacParam++);
                                    param.setParametar(listaParametara.get(i).getVrParametra());
                                    param.setDatumod(listaPeriod.get(j).getDatumOd());
                                    param.setDatumdo(listaPeriod.get(j).getDatumDo());
                                    param.setOpis(listaPeriod.get(j).getOpis());
                                    em.persist(param);
                                    em.flush();
                                    }
                            }  
                                    
                                    
                                List<ZaposlenikType.RacuniZaposlenika> listaRacuna = xmlZaposlenik.getRacuniZaposlenika();
                                for(int i=0;i<listaRacuna.size();i++){
                                    Zaprac zaprac = new Zaprac();
                                    zaprac.setObrid(iduciId);
                                    zaprac.setRbr(iduciRbr);
                                    zaprac.setStv(i+1);
                                    zaprac.setRacunzap(listaRacuna.get(i).getBrRacZap());
                                    zaprac.setRacunban(listaRacuna.get(i).getRacunBanka());
                                    zaprac.setIznos(listaRacuna.get(i).getUkIznos());
                                    
                                    em.persist(zaprac);
                                    em.flush();
                                }
                                                                                                               
                        em.clear();   
                                          
                }
                Query pozivProcedure = em.createNativeQuery("{call dbo.USP_FK_COP_VEZNE_TABLICE(?)}");
                pozivProcedure.setParameter(1, iduciId);
                pozivProcedure.executeUpdate();                                                                                                                           
                em.getTransaction().commit();                 
             
                System.out.println("kraj");
                jProgressBar1.repaint();
                Pomocna.porukaInfo(Run.frm, "Import podataka uspje�no dovr�en !");
            } catch (Exception e) {
          
                Run.forma.setPreferredSize(new Dimension(853,479));
                Run.frm.pack();
             
                jTextArea1.setText("XML:"+xmlDatoteka);
                
                if(iduciId!=null)
                jTextArea1.setText("OBRID:"+Integer.toString(iduciId));
       
                
                jTextArea1.setText(jTextArea1.getText()+"\n"+ "Rbr:"+Integer.toString(iduciRbr));
             
                 try{
                    em.getTransaction().rollback();
                    }catch(Exception e1){
                         e1.printStackTrace();
                        }   
                
                jProgressBar1.repaint();
 
                
                try{
                    jTextArea1.setText(jTextArea1.getText()+"\n"+e.getStackTrace().toString());
                }catch(Exception e1){
                    }         
                
                try{
                jTextArea1.setText(jTextArea1.getText()+"\n"+e.getMessage());
                }catch(Exception e1){
                    }
                
                jProgressBar1.setForeground(new Color(255,0,0));
                Pomocna.porukaError(Run.frm, "Gre�ka prilikom importa podataka !");
                
                
            } finally {
                em.close();
            }

            
            
            
            return null;
        }
    }
 
 
 
    public void resetirajGUI() throws JAXBException {
        //resetiram progressbar
        Run.forma.setPreferredSize(new Dimension(853,320));
        Run.frm.pack();
        
        
        jProgressBar1.setForeground(new Color(0,0,255));
        jProgressBar1.setStringPainted(true); // da prikaze postotak progressa
        jProgressBar1.setMinimum(0);
        try{
        jProgressBar1.setMaximum(brojZapisa());
        }catch(Exception e1){}
        //maximum ce se postaviti u threadu
        
        jProgressBar1.setValue(0);
        jProgressBar1.repaint();
        
        
        //brisem tablicu zaposlenika 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        
        //brisem prikaz gresaka     
        jTextArea1.setText("");
    }
    
    public void zapocniImport() throws JAXBException {
        
        
        
        if(status==-1) {
            Pomocna.porukaError(Run.frm, "Obra�un za upisani ID ne postoji !");
            return;
        }
        else if(status>10) {
            Pomocna.porukaError(Run.frm, "Obra�un ima status iznad 10 !");
            return;
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Potvrdite import podataka !", "Potvrda",dialogButton);
        if(dialogResult==0) {
            // yes
            
            if(status==10){
                int dialogButton1 = JOptionPane.YES_NO_OPTION;
                int dialogResult1 = JOptionPane.showConfirmDialog(this, "Potvrdite prepisivanje obra�una "+oldID+" !", "Potvrda",dialogButton1);
                if(dialogResult1==0) {
                    // yes
                    
                    
                    resetirajGUI();
                    t = new Task();
                    t.execute();
                    }

                } else if(status==0){
                    resetirajGUI();
                    t = new Task();
                    t.execute();
                }
            }
            

        
    }
    
    

    /** Creates new form Forma */
    public Forma() {
        
        initComponents();
        
        jProgressBar1.setForeground(new Color(0,0,255));
        jProgressBar1.setStringPainted(true);
        
        jTable1.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, 0, true));
            }
        });
        
        
        
        new  FileDrop( txtXml, new FileDrop.Listener()
          {   public void  filesDropped( java.io.File[] files ) {   
                  try{
                      if(t.isDone()==false){
                          Pomocna.porukaError(Run.frm, "Import je u tijeku !");
                          return;
                      }
                  } catch (Exception e) {
                  }

                 if(files.length>1)
                     Pomocna.porukaError(Run.frm,"Dozvoljena samo jedna datoteka !");
                 else{
                        if(files[0].getAbsolutePath().indexOf(".xml")==-1)
                            Pomocna.porukaError(Run.frm,"Datoteka treba imati xml ekstenziju !");
                        else{
                                txtXml.setText(files[0].getAbsolutePath());
                                xmlDatoteka = files[0].getAbsolutePath();
                        try {
                            zapocniImport();
                        } catch (JAXBException e) {
                        }
                    } 
                }
              }   
          });
        
        
    

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        txtXml = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(536, 365));
        setMinimumSize(new java.awt.Dimension(536, 365));
        setPreferredSize(new java.awt.Dimension(853, 320));
        setLayout(null);

        txtXml.setEditable(false);
        txtXml.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXmlActionPerformed(evt);
            }
        });
        add(txtXml);
        txtXml.setBounds(130, 50, 680, 20);

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(820, 50, 20, 21);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Gre�ke");
        add(jLabel1);
        jLabel1.setBounds(20, 340, 41, 15);
        add(jProgressBar1);
        jProgressBar1.setBounds(20, 80, 820, 30);

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rbr", "OIB", "Prezime", "Ime"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Rbr");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("OIB");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Prezime");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("Ime");

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 820, 190);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 360, 820, 110);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID obra�una");
        add(jLabel2);
        jLabel2.setBounds(20, 20, 68, 15);
        add(jSeparator1);
        jSeparator1.setBounds(20, 330, 820, 2);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("XML datoteka");
        add(jLabel3);
        jLabel3.setBounds(20, 50, 78, 15);

        jTextField1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(130, 20, 50, 20);

        lblStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(lblStatus);
        lblStatus.setBounds(190, 20, 530, 15);
    }//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try{
            if(t.isDone()==false){
                Pomocna.porukaError(Run.frm, "Import je u tijeku !");
                return;
            }
        } catch (Exception e) {
        }
        
        
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
        if(openFile.getSelectedFile()==null) return;

                      if(openFile.getSelectedFile().toString().indexOf(".xml")==-1)
                          Pomocna.porukaError(Run.frm,"Datoteka treba imati xml ekstenziju !");
                      else{
                       txtXml.setText(openFile.getSelectedFile().toString());
                          xmlDatoteka=openFile.getSelectedFile().toString();
            try {
                zapocniImport();
            } catch (JAXBException e) {
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

    }//GEN-LAST:event_jTable1ComponentAdded

    private void txtXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXmlActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        
        oldID=jTextField1.getText();
            
        if(oldID.equals("")){
            status=0;
            lblStatus.setText("");
            return;
        }
        
        try{
        EntityManagerFactory emf;
        EntityManager em = null;
        
    
         

         
            emf = Persistence.createEntityManagerFactory("infomare-cop-import-klijent", Pomocna.getPersistenceProps());
            em = emf.createEntityManager();
         
            em.getTransaction().begin();
            
            
            try{
            status = em.createQuery("select O.status FROM Obracun O where O.obrid="+oldID, Integer.class).getSingleResult();
                if(status<=10){
                lblStatus.setText("Obra�un je mogu�e pregaziti !");
                lblStatus.setForeground(new Color(0,255,10));
                } else {
                    lblStatus.setText("Obra�un nije mogu�e pregaziti (status ve�i od 10) !");
                    lblStatus.setForeground(new Color(255,0,0));
                }
            }catch(Exception e){
                    status=-1;
                    lblStatus.setText("Obra�un ne postoji !");
                    lblStatus.setForeground(new Color(255,0,0));
                }
            
        
            
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){}
        
    }//GEN-LAST:event_jTextField1FocusLost

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtXml;
    // End of variables declaration//GEN-END:variables

}
