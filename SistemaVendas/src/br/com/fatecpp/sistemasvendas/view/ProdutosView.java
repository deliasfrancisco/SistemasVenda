package br.com.fatecpp.sistemasvendas.view;

import br.com.fatecpp.sistemasvendas.model.dao.FornecedorDAO;
import br.com.fatecpp.sistemasvendas.model.dao.ProdutoDAO;
import br.com.fatecpp.sistemasvendas.model.domain.Fornecedor;
import br.com.fatecpp.sistemasvendas.model.domain.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutosView extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private List<Produto> resultado;

    public ProdutosView() {
        initComponents();
        resultadoFornecedor = FornecedorDAO.getUnicaInstancia().consultar("ConsultarTodos", "");
        if (resultadoFornecedor.size() > 0){
            for (Fornecedor f: resultadoFornecedor){
                cmbFornecedor.addItem(f.getNome())
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEstoqueMinimo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtParametro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JToggleButton();
        btnAlterar = new javax.swing.JToggleButton();
        btnInserir = new javax.swing.JToggleButton();
        cmbOpcao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cmbSelicionar = new javax.swing.JComboBox<>();
        txtCodigo4 = new javax.swing.JTextField();
        txtCodigo5 = new javax.swing.JTextField();
        txtCodigo6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setForeground(new java.awt.Color(204, 255, 204));
        setTitle("Consulta de Produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Agency FB", 0, 8)); // NOI18N
        setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(txtEstoqueMinimo);
        txtEstoqueMinimo.setBounds(210, 80, 170, 20);

        jLabel1.setText("Estoque Minimo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 60, 170, 14);

        txtCodigo.setEnabled(false);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(10, 30, 76, 20);
        getContentPane().add(txtParametro);
        txtParametro.setBounds(110, 170, 170, 20);

        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 80, 14);

        jLabel3.setText("Pesquisar Produto por:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 150, 160, 14);

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(283, 110, 100, 23);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(140, 110, 100, 23);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInserir);
        btnInserir.setBounds(10, 110, 100, 23);

        cmbOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Codigo" }));
        getContentPane().add(cmbOpcao);
        cmbOpcao.setBounds(10, 170, 90, 20);

        jLabel4.setText("Selecionar Fornecedor");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 320, 160, 20);
        getContentPane().add(txtNome);
        txtNome.setBounds(10, 80, 170, 20);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(290, 170, 90, 23);

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Estoque minimo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 370, 110);

        jLabel5.setText("Quantidade");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 380, 70, 14);

        getContentPane().add(cmbSelicionar);
        cmbSelicionar.setBounds(10, 350, 370, 20);
        getContentPane().add(txtCodigo4);
        txtCodigo4.setBounds(150, 400, 76, 20);
        getContentPane().add(txtCodigo5);
        txtCodigo5.setBounds(300, 400, 76, 20);
        getContentPane().add(txtCodigo6);
        txtCodigo6.setBounds(10, 400, 76, 20);

        jLabel6.setText("Preço de Custo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 380, 110, 14);

        jLabel7.setText("Preço de Venda");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(300, 380, 100, 14);

        jLabel8.setText("Nome");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 60, 80, 14);

        jButton2.setText("Adicionar");
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 430, 80, 23);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome do Fornecedor", "Produtos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 470, 380, 90);

        jButton3.setText("Remover Fornecedor / Produto");
        getContentPane().add(jButton3);
        jButton3.setBounds(100, 580, 230, 23);

        setBounds(480, 215, 421, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Integer estoque = Integer.parseInt(txtEstoqueMinimo.getText());
        String nome = txtNome.getText();
        Produto produto = new Produto(nome, estoque);
        ProdutoDAO.getUnicaInstancia().inserir(produto);
        JOptionPane.showMessageDialog(null, "Registro inserido");
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        modelo = (DefaultTableModel)tblTabela.getModel();
        String texto = txtParametro.getText();
        String opcao = cmbOpcao.getSelectedItem().toString();
        if (opcao.equals("Codigo")){
            resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarPorId", texto);
        }else if (opcao.equals("Nome")){
            resultado = ProdutoDAO.getUnicaInstancia().consultar("consultarPorNome", texto);
        }
        if (resultado.size() > 0) {
            while (modelo.getRowCount() > 0) {
               modelo.removeRow(0);
            }
            for (Produto c :  resultado) {
                modelo.addRow(
                    new Object[]{
                    c.getIdProduto(),
                    c.getNome()
                });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma resgistro encontrado!");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tblTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabelaMouseClicked
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnInserir.setEnabled(false);
        int i = tblTabela.getSelectedRow();
        txtCodigo.setText(String.valueOf(resultado.get(i).getIdProduto()));
        txtNome.setText(resultado.get(i).getNome());
        txtEstoqueMinimo.setText( String.valueOf(resultado.get(i).getEstoqueMinimo()));
    }//GEN-LAST:event_tblTabelaMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Produto produto = new Produto(txtNome.getText(), Integer.parseInt(txtEstoqueMinimo.getText()));
        ProdutoDAO.getUnicaInstancia().alterar(produto);
        JOptionPane.showMessageDialog(null, "Registro alterado");
        txtCodigo.setText("");
        txtNome.setText("");
        txtEstoqueMinimo.setText("");
        btnAlterar.setEnabled(true);
        btnInserir.setEnabled(false);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JToggleButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbOpcao;
    private javax.swing.JComboBox<String> cmbSelicionar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblTabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo4;
    private javax.swing.JTextField txtCodigo5;
    private javax.swing.JTextField txtCodigo6;
    private javax.swing.JTextField txtEstoqueMinimo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtParametro;
    // End of variables declaration//GEN-END:variables
}
