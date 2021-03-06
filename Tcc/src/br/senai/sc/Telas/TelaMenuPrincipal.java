/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.Telas;

import br.senai.sc.DAO.UsuariopatosDAO;
import br.senai.sc.DAO.UsuariosDAO;
import br.senai.sc.Entidades.InfoUsuario;
import br.senai.sc.Entidades.Usuariopatos;
import br.senai.sc.Entidades.Usuarios;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno_verbinnen
 */
public class TelaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    JLabel moedas = new JLabel();
    
    
    public TelaMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        bar.add(Box.createRigidArea(new Dimension(500,0)));
        moedas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/moeda.gif")));
        moedas.setText("Moedas: 0");
        bar.add(moedas);
        
    }
    Usuarios usu = new Usuarios();
    UsuariosDAO usuDAO = new UsuariosDAO();
    InfoUsuario IU = new InfoUsuario();
    UsuariopatosDAO upDAO = new UsuariopatosDAO();
    Usuariopatos up = new Usuariopatos();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        melhor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        informacoesusu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        loja = new javax.swing.JMenu();
        escolhaperso = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 450));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/suaMelhor.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(25, 79, 250, 100);

        melhor.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        melhor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        melhor.setText("666666");
        jPanel1.add(melhor);
        melhor.setBounds(70, 130, 160, 100);

        jTable1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 51));
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 0));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(588, 60, 240, 310);

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/TOP10.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(580, 10, 250, 50);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CLICK");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(380, 290, 80, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/menu.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 60, 240, 305);

        menu.setText("Menu");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        menu.add(logout);

        informacoesusu.setText("Informações de Usuário");
        informacoesusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacoesusuActionPerformed(evt);
            }
        });
        menu.add(informacoesusu);

        jMenuItem1.setText("Extras");
        menu.add(jMenuItem1);

        bar.add(menu);

        loja.setText("Loja");
        loja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lojaMouseClicked(evt);
            }
        });
        bar.add(loja);

        escolhaperso.setText("Escolher Personagem");
        escolhaperso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escolhapersoMouseClicked(evt);
            }
        });
        bar.add(escolhaperso);

        setJMenuBar(bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Atualizar();
        
    }//GEN-LAST:event_formWindowOpened

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        InfoUsuario IF = new InfoUsuario();
        IF.setAdm(false);
        IF.setIdusu(0);
        
        TelaLogin Abrir = new TelaLogin();
        Abrir.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void lojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lojaMouseClicked
        // TODO add your handling code here:
        TelaLojaPersonagem abrir = new TelaLojaPersonagem();
        abrir.setVisible(true);
        dispose();
    }//GEN-LAST:event_lojaMouseClicked

    private void escolhapersoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escolhapersoMouseClicked
        // TODO add your handling code here:
        int id=0;
        usu.setIdusuario(IU.getIdusu());
        up.setUsuarioID(usu);
        try {
            
            id = upDAO.ComproPato(up);
        } catch (Exception ex) {
            Logger.getLogger(TelaEscolhaPato.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id==0){
            JOptionPane.showMessageDialog(null, "Compre um pato para acessar essa tela!");
        }else{
            TelaEscolhaPato abrir = new TelaEscolhaPato();
            abrir.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_escolhapersoMouseClicked

    private void informacoesusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacoesusuActionPerformed
        // TODO add your handling code here:
        TelaInformacoesdeUsuario abrir = new TelaInformacoesdeUsuario();
        abrir.setVisible(true);
        dispose();
    }//GEN-LAST:event_informacoesusuActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        int id=0;
        usu.setIdusuario(IU.getIdusu());
        up.setUsuarioID(usu);
        try {
            
            id = upDAO.AcharPato(up);
        } catch (Exception ex) {
            Logger.getLogger(TelaEscolhaPato.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id==-1){
            JOptionPane.showMessageDialog(null, "Selecione um pato para jogar!");
        }else{
            TelaJogo abrir = new TelaJogo();
            abrir.setVisible(true);
            dispose();
        }
        
//        usu.setMoedas(usu.getMoedas()+5);
//        usu.setPontos(usu.getPontos()+10);
//        try {
//            usuDAO.alterar(usu);
//        } catch (Exception ex) {
//            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Atualizar();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        int id=0;
        usu.setIdusuario(IU.getIdusu());
        up.setUsuarioID(usu);
        try {
            
            id = upDAO.AcharPato(up);
        } catch (Exception ex) {
            Logger.getLogger(TelaEscolhaPato.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id==-1){
            JOptionPane.showMessageDialog(null, "Selecione um pato para jogar!");
        }else{
            TelaJogo abrir = new TelaJogo();
            abrir.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuPrincipal().setVisible(true);
            }
        });
    }
    
    public void Atualizar(){
        InfoUsuario IF = new InfoUsuario();
        try {
            usu = usuDAO.getUsuarioPorID(IF.getIdusu());
            
            jTable1.setModel(usuDAO.getMd10());
            
        } catch (Exception ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        moedas.setText("Moedas: "+usu.getMoedas());
        melhor.setText(""+usu.getPontos());
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar bar;
    private javax.swing.JMenu escolhaperso;
    private javax.swing.JMenuItem informacoesusu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu loja;
    private javax.swing.JLabel melhor;
    private javax.swing.JMenu menu;
    // End of variables declaration//GEN-END:variables
}
