package br.com.fatecpp.sistemasvendas.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "venda_produto")
@NamedQueries({
    @NamedQuery(name = "VendaProduto.findAll", query = "SELECT v FROM VendaProduto v")
    , @NamedQuery(name = "VendaProduto.findByIdVendaProduto", query = "SELECT v FROM VendaProduto v WHERE v.idVendaProduto = :idVendaProduto")
    , @NamedQuery(name = "VendaProduto.findByQuantidade", query = "SELECT v FROM VendaProduto v WHERE v.quantidade = :quantidade")
    , @NamedQuery(name = "VendaProduto.findByPrecoCusto", query = "SELECT v FROM VendaProduto v WHERE v.precoCusto = :precoCusto")
    , @NamedQuery(name = "VendaProduto.findByPrecoUnitario", query = "SELECT v FROM VendaProduto v WHERE v.precoUnitario = :precoUnitario")})

public class VendaProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda_produto")
    private int idVendaProduto;
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_custo")
    private BigDecimal precoCusto;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;
    @JoinColumn(name = "venda_id_venda", referencedColumnName = "id_venda")
    @ManyToOne(optional = false)
    private Venda vendaIdVenda;

    public VendaProduto() {
    }

    public VendaProduto(Integer idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public Integer getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(Integer idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Produto produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    public Venda getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(Venda vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    @Override
    public String toString() {
        return "br.com.fatecpp.sistemasvendas.model.domain.VendaProduto[ idVendaProduto=" + idVendaProduto + " ]";
    }
    
}
