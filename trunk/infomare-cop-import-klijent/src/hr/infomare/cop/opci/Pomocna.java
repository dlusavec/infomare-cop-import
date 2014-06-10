package hr.infomare.cop.opci;

import java.awt.Component;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.lang.reflect.Field;

import java.util.HashMap;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import javax.swing.JOptionPane;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class Pomocna {
    public Pomocna() {
        super();
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
            hm.put(PersistenceUnitProperties.JDBC_URL, "jdbc:as400://"+Aes.decrypt(prop.getProperty("server"))+";prompt=false");

            
            return hm;
        }
    
    public static void spremiPostavke(String server, String korisnickoIme, String lozinka){
        Properties prop = new Properties();
        OutputStream output = null;
        
        try {
        
                output = new FileOutputStream("postavke.properties");
        
        
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
    public static boolean postavkeIspravne(){
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
