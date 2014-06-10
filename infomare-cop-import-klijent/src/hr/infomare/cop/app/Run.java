package hr.infomare.cop.app;


import hr.infomare.cop.jaxb.OpObrasci;

import hr.infomare.cop.jaxb.ZaposlenikType;

import java.io.File;

import java.util.Collection;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import hr.infomare.cop.jaxb.*;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hr.infomare.cop.opci.Aes;

import hr.infomare.cop.opci.Pomocna;

import java.awt.CardLayout;
import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Run{
    
    public static JFrame frm;
    
    public static JPanel cards;
    public static JPanel login;
    public static JPanel forma;
    public static CardLayout cl;
    
    
    public Run() {
        super();
    }
    
    public static void promijeniCard(String naziv){
        cl.show(Run.cards, naziv);   
        frm.pack();
        frm.setLocationRelativeTo(null);
    }  
        
          

    public static void main(String[] args) throws JAXBException, ClassNotFoundException, InstantiationException,
                                                  IllegalAccessException, UnsupportedLookAndFeelException {
        
        
        frm = new JFrame("Cop import");      
        
        JMenuBar menuBar = new JMenuBar();
        
            JMenu programMenu = new JMenu("Program");
                JMenuItem closeMenuItem = new JMenuItem("Izlaz");
                closeMenuItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            System.exit(0);
                        }});
            programMenu.add(closeMenuItem);
        
        menuBar.add(programMenu);
        
        frm.setJMenuBar(menuBar);
        
                

        cards = new JPanel(new MCardLayout());
            login = new Login();
            forma = new Forma();
            
            
        cards.add(login,"Login");
        cards.add(forma,"Forma");
        
        frm.getContentPane().add(cards);
        
        cl = (CardLayout) cards.getLayout();
    
    

        if(Pomocna.postavkeIspravne())
            promijeniCard("Forma");
        else promijeniCard("Login");
     
        
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        for(Window window : JFrame.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
            }

         

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.pack();
        frm.setLocationRelativeTo(null);   // da se pokrene u centru ekrana
        frm.setVisible(true);
        
        
        
        
        

    }
}
