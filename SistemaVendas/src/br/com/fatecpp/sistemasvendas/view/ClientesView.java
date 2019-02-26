package br.com.fatecpp.sistemasvendas.view;

import br.com.fatecpp.sistemasvendas.model.dao.ClienteDAO;
import br.com.fatecpp.sistemasvendas.model.domain.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClientesView extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private List<Cliente> resultado;

    public ClientesView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gerenciamento de Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 34, -1));

        txtCodigo.setEditable(false);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, -1));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 360, -1));

        jLabel3.setText("E-mail");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 360, -1));

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 73, -1));

        setBounds(480, 215, 410, 251);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Cliente cliente = new Cliente(txtNome.getText(), txtEmail.getText());
        ClienteDAO.getUnicaInstancia().inserir(cliente);
        JOptionPane.showMessageDialog(null, "Registro inserido");
    }//GEN-LAST:event_btnInserirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
