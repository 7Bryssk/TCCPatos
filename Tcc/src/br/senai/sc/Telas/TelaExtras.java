/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author bruni
 */
public class TelaExtras extends javax.swing.JFrame {
    List<JLabel> ListaInformacoes = new ArrayList<>();
    List<JLabel> ListaInformacoesTela = new ArrayList<>();
    Timer loop;
    /**
     * Creates new form TelaExtras
     */
    public TelaExtras() {
        initComponents();
        iniciarlabels();
        loop = new Timer(10 , new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Mover(ListaInformacoesTela);
                Adicionar(ListaInformacoes, ListaInformacoesTela);
            }
            
        });
        loop.start();
    }
    
    public void Adicionar(List<JLabel> inf, List<JLabel> inftela){
        int tem = 0;
        for (JLabel infdd : inf) {
            for (JLabel info : inftela) {
                if(infdd.getText().equals(info.getText())){
                    tem = 1;
                    JOptionPane.showMessageDialog(null, tem);
                }else{
                    JOptionPane.showMessageDialog(null, tem);
                }
            }
            if(tem == 0){
                JOptionPane.showMessageDialog(null, inftela.size());
                if(inftela.size()==0){
                    JLabel novainfo = new JLabel();
//                novainfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/moeda.gif")));
                    novainfo.setRequestFocusEnabled(false);
                    novainfo.setForeground(infdd.getForeground());
                    novainfo.setFont(infdd.getFont());
                    novainfo.setBounds(0, 400, 500, 50);
                    novainfo.setAlignmentX(CENTER_ALIGNMENT);
                    ListaInformacoesTela.add(novainfo);
                    for (JLabel infAtual : ListaInformacoesTela) {
                        painel.add(infAtual);
                        JOptionPane.showMessageDialog(null, "add 1");
                    }
                    novainfo.setVisible(true);
                    
                }else if(inftela.get(inftela.size()-1).getLocation().getY()>=300){
                    JLabel novainfo = new JLabel();
//                novainfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/moeda.gif")));
                    novainfo.setRequestFocusEnabled(false);
                    novainfo.setForeground(infdd.getForeground());
                    novainfo.setFont(infdd.getFont());
                    novainfo.setBounds(0, 400, 500, 50);
                    novainfo.setAlignmentX(CENTER_ALIGNMENT);
                    ListaInformacoesTela.add(novainfo);
                    for (JLabel infAtual : ListaInformacoesTela) {
                        painel.add(infAtual);
                    }
                    novainfo.setVisible(true);
                }
                
            }else{
                tem = 0;
            }
        }
    }
    public void Mover(List<JLabel> Info){
        for (JLabel in : Info) {
            in.setLocation((int) in.getLocation().getX(), (int) in.getLocation().getY()-4);
        }
    }
    public void iniciarlabels(){
                    JLabel info = new JLabel();
                    
                    
                    info.setRequestFocusEnabled(false);
                    info.setForeground(Color.WHITE);
                    info.setText("Bruno");
//                    info.setFont(new Font(null, WIDTH, WIDTH));
                    info.setBounds(5000, 400, 500, 50);
                    info.setAlignmentX(CENTER_ALIGNMENT);
                    ListaInformacoesTela.add(info);
                    for (JLabel infAtual : ListaInformacoes) {
                        painel.add(infAtual);
                    }
                    info.setVisible(true);
                    JOptionPane.showMessageDialog(null, "labels");
                    
//                    info.setRequestFocusEnabled(false);
//                    info.setForeground(Color.WHITE);
//                    info.setText("Ana");
//                    info.setFont(new Font(null, WIDTH, WIDTH));
//                    info.setBounds(5000, 400, 500, 50);
//                    info.setAlignmentX(CENTER_ALIGNMENT);
//                    ListaInformacoesTela.add(info);
//                    for (JLabel infAtual : ListaInformacoes) {
//                        painel.add(infAtual);
//                    }
//                    info.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExtras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExtras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
