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
@Table(name = "fornecedor_produto")
@NamedQueries({
    @NamedQuery(name = "FornecedorProduto.findAll", query = "SELECT f FROM FornecedorProduto f")
    , @NamedQuery(name = "FornecedorProduto.findByIdFornecedorProduto", query = "SELECT f FROM FornecedorProduto f WHERE f.idFornecedorProduto like :idFornecedorProduto")
    , @NamedQuery(name = "FornecedorProduto.findByEstoque", query = "SELECT f FROM FornecedorProduto f WHERE f.estoque like :estoque")
    , @NamedQuery(name = "FornecedorProduto.findByPrecoCusto", query = "SELECT f FROM FornecedorProduto f WHERE f.precoCusto like :precoCusto")
    , @NamedQuery(name = "FornecedorProduto.findByPrecoUnitario", query = "SELECT f FROM FornecedorProduto f WHERE f.precoUnitario like :precoUnitario")})
public class FornecedorProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor_produto")
    private int idFornecedorProduto;
    @Column(name = "estoque")
    private int estoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_custo")
    private BigDecimal precoCusto;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    @JoinColumn(name = "fornecedor_id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorIdFornecedor;
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;

    public FornecedorProduto() {
    }

    public FornecedorProduto(Integer idFornecedorProduto) {
        this.idFornecedorProduto = idFornecedorProduto;
    }

    public Integer getIdFornecedorProduto() {
        return idFornecedorProduto;
    }

    public void setIdFornecedorProduto(Integer idFornecedorProduto) {
        this.idFornecedorProduto = idFornecedorProduto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
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

    public Fornecedor getFornecedorIdFornecedor() {
        return fornecedorIdFornecedor;
    }

    public void setFornecedorIdFornecedor(Fornecedor fornecedorIdFornecedor) {
        this.fornecedorIdFornecedor = fornecedorIdFornecedor;
    }

    public Produto getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Produto produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    @Override
    public String toString() {
        return "br.com.fatecpp.sistemasvendas.model.domain.FornecedorProduto[ idFornecedorProduto=" + idFornecedorProduto + " ]";
    }
    
}
