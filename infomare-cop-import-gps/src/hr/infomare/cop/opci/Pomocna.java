package hr.infomare.cop.opci;

import java.awt.Component;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.lang.reflect.Field;

import java.util.HashMap;

import java.util.Properties;

import java.util.logging.FileHandler;
import java.util.logging.Level;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import javax.persistence.Query;

import javax.swing.JOptionPane;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import javax.xml.validation.Validator;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class Pomocna {
    public Pomocna() {
        super();
    }
    
    public static void obrisiNalog(int idObracuna){
        try{
        
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("infomare-cop-import-klijent",getPersistenceProps());
             EntityManager em = emf.createEntityManager();
         
             em.getTransaction().begin();
            int cnt=0;
            System.out.println("Brisem obracun sa id:"+idObracuna);

                cnt=em.createQuery("delete from Poduzece p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Zaposl p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Prihod p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Poripri p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Obracun p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Param p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Olaksica p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Doprinos p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Obustava p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
                cnt=em.createQuery("delete from Zaprac p where p.obrid="+Integer.toString(idObracuna)).executeUpdate();
        

            
             em.getTransaction().commit();

             em.close();
        }catch(Exception ex){
            System.out.println("greska");
            ex.printStackTrace();
        }
        
    }

    
    
    public static HashMap getPersistenceProps() throws Exception {
            HashMap hm = new HashMap();
                        
                        
                        
            Properties prop = new Properties();
            InputStream input = null;
        

        
                input = new FileInputStream("postavke.properties");
                 prop.load(input);  
                
            //Pomocna.porukaInfo(null,  Aes.decrypt(prop.getProperty("korisnik")));
            //Pomocna.porukaInfo(null, Aes.decrypt(prop.getProperty("lozinka")));
            //Pomocna.porukaInfo(null, "jdbc:as400://"+Aes.decrypt(prop.getProperty("server"))+";prompt=false");

                                
            hm.put(PersistenceUnitProperties.JDBC_USER, Aes.decrypt(prop.getProperty("korisnik")));
            hm.put(PersistenceUnitProperties.JDBC_PASSWORD, Aes.decrypt(prop.getProperty("lozinka")));             
            
            // Oracle
            //jdbc:oracle:thin:@//[HOST][:PORT]/SERVICE
            // String url = "jdbc:oracle:thin:@//myhost:1521/orcl";            
            if (Aes.decrypt(prop.getProperty("rdbms")).equals("O")){
                hm.put(PersistenceUnitProperties.JDBC_DRIVER, "oracle.jdbc.driver.OracleDriver"); 
                hm.put(PersistenceUnitProperties.JDBC_URL, "jdbc:oracle:thin:@//"+Aes.decrypt(prop.getProperty("server"))+"/"+Aes.decrypt(prop.getProperty("baza")));   
            }
            
            //SQL Server
            //jdbc:sqlserver://LEUT;user=magicapp;password=magicapp;databaseName=GPSDB;
            if (Aes.decrypt(prop.getProperty("rdbms")).equals("S")){
                hm.put(PersistenceUnitProperties.JDBC_DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
                hm.put(PersistenceUnitProperties.JDBC_URL, "jdbc:sqlserver://"+Aes.decrypt(prop.getProperty("server"))+";databaseName="+Aes.decrypt(prop.getProperty("baza")));   
            }  

            
            return hm;
        }
    
    public static void spremiPostavke(String rdbms, String baza, String server, String korisnickoIme, String lozinka){
        Properties prop = new Properties();
        OutputStream output = null;
        
        try {
        
                output = new FileOutputStream("postavke.properties");
        
                prop.setProperty("rdbms", Aes.encrypt(rdbms));
                prop.setProperty("baza", Aes.encrypt(baza));
                prop.setProperty("server", Aes.encrypt(server));
                prop.setProperty("korisnik", Aes.encrypt(korisnickoIme));
                prop.setProperty("lozinka", Aes.encrypt(lozinka));
                
        
                // save properties to project root folder
                prop.store(output, null);
        
        } catch (IOException io) {
                io.printStackTrace();
        } catch (Exception e) {
        } finally {
                if (output != null) {
                        try {
                                output.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

    }
    
    //postavke za spajanje na server 
    public static boolean postavkeIspravne() {
        boolean ispravne = true;
        
        try{
     
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("infomare-cop-import-klijent",getPersistenceProps());
             EntityManager em = emf.createEntityManager();
         
             em.getTransaction().begin();

             em.getTransaction().commit();

             em.close();
        }catch(Exception ex){ 
            ispravne=false;    
        }
        return ispravne;        
        
    }
    
    public static void log(String msg){
         try
         {
             String filename= "log.txt";
             FileWriter fw = new FileWriter(filename,true); 
             fw.write(msg+"\n");
             fw.close();
         }
         catch(IOException ioe)
         {
             System.err.println("IOException: " + ioe.getMessage());
         }
     }

    
    public synchronized static void  debugObjekta(Object object) {
        if (object == null) {
            System.err.println("Debug null referenca!!!");
        } else {
            Class klasa = object.getClass();
            Field[] polja = klasa.getDeclaredFields();
            for (Field polje : polja) {
                polje.setAccessible(true);
                try {
                    System.out.println("----------------------------------------");
                    System.out.println(polje.getName() + ": " + polje.get(object));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
    
    public static void porukaInfo(Component c,String poruka){
        JOptionPane.showMessageDialog(c,poruka,"Informacija",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void porukaError(Component c,String poruka){
        JOptionPane.showMessageDialog(c,poruka,"Greška",JOptionPane.ERROR_MESSAGE);
    }
}
