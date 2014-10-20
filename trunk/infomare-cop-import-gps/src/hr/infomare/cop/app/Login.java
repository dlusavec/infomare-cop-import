
package hr.infomare.cop.app;

import hr.infomare.cop.opci.Pomocna;
import hr.infomare.cop.app.*;

import java.awt.CardLayout;


/**
 *
 * @author ivanj
 */
public class Login extends javax.swing.JPanel {

    /** Creates new form Login */
    public Login() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btnSpremi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKorisnik = new javax.swing.JTextField();
        txtLozinka = new javax.swing.JPasswordField();
        btnOdustani = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtRdbms = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBaza = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(300, 190));
        setMinimumSize(new java.awt.Dimension(300, 180));
        setPreferredSize(new java.awt.Dimension(300, 190));
        setLayout(null);

        btnSpremi.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSpremi.setText("Spremi");
        btnSpremi.setMaximumSize(new java.awt.Dimension(84, 22));
        btnSpremi.setMinimumSize(new java.awt.Dimension(84, 22));
        btnSpremi.setPreferredSize(new java.awt.Dimension(84, 25));
        btnSpremi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpremiActionPerformed(evt);
            }
        });
        add(btnSpremi);
        btnSpremi.setBounds(10, 160, 77, 25);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Server");
        add(jLabel1);
        jLabel1.setBounds(10, 40, 38, 15);

        txtServer.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtServer.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtServer.setMaximumSize(null);
        txtServer.setPreferredSize(new java.awt.Dimension(4, 20));
        add(txtServer);
        txtServer.setBounds(130, 40, 154, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Korisničko ime");
        add(jLabel2);
        jLabel2.setBounds(10, 100, 90, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Lozinka");
        add(jLabel3);
        jLabel3.setBounds(10, 130, 44, 15);

        txtKorisnik.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtKorisnik.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtKorisnik.setMaximumSize(new java.awt.Dimension(4, 19));
        txtKorisnik.setPreferredSize(new java.awt.Dimension(4, 20));
        add(txtKorisnik);
        txtKorisnik.setBounds(130, 100, 154, 20);

        txtLozinka.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        add(txtLozinka);
        txtLozinka.setBounds(130, 130, 154, 20);

        btnOdustani.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnOdustani.setText("Odustani");
        btnOdustani.setPreferredSize(new java.awt.Dimension(84, 25));
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });
        add(btnOdustani);
        btnOdustani.setBounds(200, 160, 84, 25);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("RDBMS");
        add(jLabel4);
        jLabel4.setBounds(10, 10, 50, 15);

        txtRdbms.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtRdbms.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtRdbms.setMaximumSize(null);
        txtRdbms.setPreferredSize(new java.awt.Dimension(4, 20));
        add(txtRdbms);
        txtRdbms.setBounds(130, 10, 30, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Baza");
        add(jLabel5);
        jLabel5.setBounds(10, 70, 38, 15);

        txtBaza.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtBaza.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtBaza.setMaximumSize(null);
        txtBaza.setPreferredSize(new java.awt.Dimension(4, 20));
        add(txtBaza);
        txtBaza.setBounds(130, 70, 154, 20);
    }//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnSpremiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpremiActionPerformed
        // TODO add your handling code here:
        
        Pomocna.spremiPostavke(txtRdbms.getText(),txtBaza.getText(),txtServer.getText(), txtKorisnik.getText(), txtLozinka.getText());
        try{
            if (Pomocna.postavkeIspravne()){
                Run.promijeniCard("Forma");
            } else Pomocna.porukaError(this,"Postavke nisu ispravne !");
        } catch(Exception ex){}
    }//GEN-LAST:event_btnSpremiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSpremi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBaza;
    private javax.swing.JTextField txtKorisnik;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JTextField txtRdbms;
    private javax.swing.JTextField txtServer;
    // End of variables declaration//GEN-END:variables

}
