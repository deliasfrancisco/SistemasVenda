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
        cmbOpcao = new javax.swing.JComboBox<>();
        lblPsq = new javax.swing.JLabel();
        txtParametro = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

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
        getContentPane().add(btnInserir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 73, -1));

        cmbOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "E-mail" }));
        getContentPane().add(cmbOpcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, -1));

        lblPsq.setText("Pesquisar por:");
        getContentPane().add(lblPsq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        getContentPane().add(txtParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 170, -1));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 370, 200));

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        setBounds(480, 215, 410, 537);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Cliente cliente = new Cliente(txtNome.getText(), txtEmail.getText());
        ClienteDAO.getUnicaInstancia().inserir(cliente);
        JOptionPane.showMessageDialog(null, "Registro inserido");
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        modelo = (DefaultTableModel)tblTabela.getModel();
        String texto = txtParametro.getText();
        String opcao = cmbOpcao.getSelectedItem().toString();
        if (opcao.equals("Codigo")){
            resultado = ClienteDAO.getUnicaInstancia().consultar("ConsultarPorId", txtParametro.getText());
        }else if (opcao.equals("Nome")){
            resultado = ClienteDAO.getUnicaInstancia().consultar("ConsultarPorNome", txtParametro.getText());
        }else if (opcao.equals("Email")){
            resultado = ClienteDAO.getUnicaInstancia().consultar("ConsultarPorEmail", txtParametro.getText());
        }
        if (resultado.size() > 0) {
            while (modelo.getRowCount() > 0) {
               modelo.removeRow(0);
            }
            for (Cliente c :  resultado) {
                modelo.addRow(
                    new Object[]{
                    c.getIdCliente(),
                    c.getNome(),
                    c.getEmail()
                });
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Nenhuma resgistro encontrado!");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabelaMouseClicked
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnInserir.setEnabled(false);
        int i = tblTabela.getSelectedRow();
        txtCodigo.setText(
                String.valueOf(
                        resultado.get(i)
                                .getIdCliente()));
        txtNome.setText(resultado.get(i).getNome());
        txtEmail.setText(resultado.get(i).getEmail());
    }//GEN-LAST:event_tblTabelaMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Cliente cliente = new Cliente(
                Integer.parseInt(txtNome.getText()),
                        txtNome.getText(),
                        txtEmail.getText());
        ClienteDAO.getUnicaInstancia().alterar(cliente);
        JOptionPane.showMessageDialog(null, "Registro alterado");
        txtCodigo.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        btnAlterar.setEnabled(true);
        btnInserir.setEnabled(false);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbOpcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPsq;
    private javax.swing.JTable tblTabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtParametro;
    // End of variables declaration//GEN-END:variables
}
