
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

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;



import java.io.File;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Collection;

import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author ivanj
 */
public class Forma extends javax.swing.JPanel {
    
    public String xmlDatoteka;
    
    class Task extends SwingWorker<Void, Void> {
        
        
        public int brojZapisa() throws JAXBException {
            JAXBContext jc = JAXBContext.newInstance(OpObrasci.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            
            OpObrasci obrasci= (OpObrasci)
               unmarshaller.unmarshal(new File(xmlDatoteka));
            
            List<ZaposlenikType> listaZaposlenika= obrasci.getZaposlenik();
            
            return listaZaposlenika.size();
        }
        
        

        @Override
        public Void doInBackground() throws Exception {

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

            jProgressBar1.setStringPainted(true); // da prikaze postotak progressa
            jProgressBar1.setMinimum(0);
            jProgressBar1.setMaximum(brojZapisa());

            EntityManagerFactory emf;
        
                emf =
                    Persistence.createEntityManagerFactory("infomare-cop-import-klijent",
                                                           Pomocna.getPersistenceProps());

            EntityManager em = emf.createEntityManager();

            try {
                em.getTransaction().begin();
                
                //pronadji iduci ID obracuna
                Integer iduciId = em.createQuery("select max(O.obrid) FROM Obracun O", Integer.class).getSingleResult();
                if (iduciId==null) iduciId=0;
                iduciId=iduciId+1;
                
                
                System.out.println(Integer.toString(iduciId));
                // èitanje xml-a i insert podataka

                System.out.println("pocetak");
                
                
                
                
                JAXBContext jc = JAXBContext.newInstance(OpObrasci.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                
                OpObrasci obrasci= (OpObrasci)
                   unmarshaller.unmarshal(new File(xmlDatoteka));
                
                
                Obracun obracun = new Obracun();
                obracun.setObrid(iduciId);
                obracun.setK50god(0);
                obracun.setK50nal(0);
                obracun.setStatus(0);
                em.persist(obracun);
                
                
              InstitucijaType xmlPoslodavac = obrasci.getPoslodavac();
                
                Poduzece poduzece = new Poduzece();
                poduzece.setObrid(iduciId);
                poduzece.setOib(xmlPoslodavac.getOib());
                poduzece.setNaziv(xmlPoslodavac.getNaziv());
                poduzece.setAdresa(xmlPoslodavac.getAdresa());
                poduzece.setPeriodod(df.parse(xmlPoslodavac.getRazdobljePocetak()));
                poduzece.setPerioddo(df.parse(xmlPoslodavac.getRazdobljeZavrsetak()));
                poduzece.setFondsati(xmlPoslodavac.getMjBrSati());                
                poduzece.setDatumobr(df.parse(xmlPoslodavac.getDatumObracuna()));
                if(xmlPoslodavac.isIsplata())
                      poduzece.setIsplata("1"); // 1- da
                else poduzece.setIsplata("0");  // 0- ne
                poduzece.setRacunisp(xmlPoslodavac.getBrRacInst());
                
                em.persist(poduzece);
                
                
                
                
                List<ZaposlenikType> listaZaposlenika= obrasci.getZaposlenik();
                
                for(ZaposlenikType xmlZaposlenik : listaZaposlenika){
                    
                                 jProgressBar1.setValue(jProgressBar1.getValue()+1);
                                    
                                   System.out.println(xmlZaposlenik.getIme()+" "+xmlZaposlenik.getPrezime());
                                
                                
                                //pronadji iduci Rbr  ovo se moze optimizirati da koristi brojac iz petlje pa
                                // ce se ustedjeti na puno upita
                                Integer iduciRbr = em.createQuery("select max(Z.rbr) FROM Zaposl Z where Z.obrid="+Integer.toString(iduciId), Integer.class).getSingleResult();
                                if (iduciRbr==null) iduciRbr=0;
                                iduciRbr=iduciRbr+1;
                                
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
                                 zaposl.setPrimanja(xmlZaposlenik.getNeto());               // ovo ok?
                                 zaposl.setObustave(xmlZaposlenik.getObustave().getUkIznos());
                                 zaposl.setIsplata(xmlZaposlenik.getIznosZaisplatu());
                                 zaposl.setTrosakpl(xmlZaposlenik.getUkTrosakPlace());
                
                                 em.persist(zaposl);
                    
                    
                    
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
                                    
                                    
                                    em.persist(obustava);
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
                                }
                                    
                                
                                ZaposlenikType.NeoporeziviPrihodi xmlZaplNeoPrih =  xmlZaposlenik.getNeoporeziviPrihodi();
                                List<NeoporeziviPrihodiType> listaNeoPrih = xmlZaplNeoPrih.getElementNeoporezPrih();
                                for(int i=0;i<listaNeoPrih.size();i++){
                                    Prihod prihod = new Prihod();
                                    prihod.setObrid(iduciId);
                                    prihod.setRbr(iduciRbr);
                                    prihod.setStv(i+1);
                                    prihod.setPrihod(listaNeoPrih.get(i).getElementPlace().getVrPrihoda());
                                    prihod.setNaziv(listaNeoPrih.get(i).getElementPlace().getNaziv());
                                    prihod.setNeoporez("1");  // 1 - neoporezivi primitak ,2 - bruto
                                    prihod.setInternauj(null);
                                    prihod.setNaziv(null);
                                    prihod.setSati(listaNeoPrih.get(i).getBrSati());
                                    prihod.setKoef(null);
                                    prihod.setOsnovica(null);
                                    prihod.setIznos(listaNeoPrih.get(i).getIznos());
                                    
                                    em.persist(prihod);
                                }
                    
                                ZaposlenikType.Bruto xmlZaplBruto = xmlZaposlenik.getBruto();
                                List<BrutoType> listaBruto = xmlZaplBruto.getElementBrutoPlace();
                                for(int i=0;i<listaBruto.size();i++){
                                    Prihod prihod = new Prihod();
                                    prihod.setObrid(iduciId);
                                    prihod.setRbr(iduciRbr);
                                    prihod.setStv(i+1);
                                    prihod.setPrihod(listaBruto.get(i).getElementPlace().getVrPrihoda());
                                    prihod.setNaziv(listaBruto.get(i).getElementPlace().getNaziv());
                                    prihod.setNeoporez("2");   // 2- bruto
                                    prihod.setInternauj(listaBruto.get(i).getInternaOznakaUJ());
                                    prihod.setNazivuj(listaBruto.get(i).getNazivUJ());
                                    prihod.setSati(listaBruto.get(i).getBrSati());
                                    prihod.setKoef(listaBruto.get(i).getKoeficijent());
                                    prihod.setOsnovica(listaBruto.get(i).getOsnovica());
                                    prihod.setIznos(listaBruto.get(i).getIznos());
                                    
                                    em.persist(prihod);
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
                                }
                            
                            
                    
                } 
                System.out.println("kraj");


                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
            } finally {
                em.close();
            }

            return null;
        }
    }
 
    
    public void zapocniImport(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Potvrdite import podataka !", "Potvrda",dialogButton);
        if(dialogResult==0) {
            // yes
            Task t = new Task();
            t.execute();
            
        }
    }
    
    

    /** Creates new form Forma */
    public Forma() {
        
        initComponents();
        
        jProgressBar1.setStringPainted(true);
        
        new  FileDrop( txtXml, new FileDrop.Listener()
          {   public void  filesDropped( java.io.File[] files )
              {   

                 if(files.length>1)
                     Pomocna.porukaInfo(Run.frm,"Dozvoljena samo jedna datoteka !");
                 else{
                        if(files[0].getAbsolutePath().indexOf(".xml")==-1)
                            Pomocna.porukaInfo(Run.frm,"Datoteka treba imati xml ekstenziju !");
                        else{
                            txtXml.setText(files[0].getAbsolutePath());
                            xmlDatoteka=files[0].getAbsolutePath();
                            zapocniImport();
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

        setMaximumSize(new java.awt.Dimension(536, 365));
        setMinimumSize(new java.awt.Dimension(536, 365));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtXml.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(txtXml, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 700, -1));

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 20, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("XML datoteka");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 820, 20));
    }//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser openFile = new JFileChooser();
        openFile.showOpenDialog(null);
        if(openFile.getSelectedFile()==null) return;

                      if(openFile.getSelectedFile().toString().indexOf(".xml")==-1)
                          Pomocna.porukaInfo(Run.frm,"Datoteka treba imati xml ekstenziju !");
                      else{
                       txtXml.setText(openFile.getSelectedFile().toString());
                          xmlDatoteka=openFile.getSelectedFile().toString();
                          zapocniImport();
                      }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txtXml;
    // End of variables declaration//GEN-END:variables

}
