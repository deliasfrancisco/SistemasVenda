package br.com.fatecpp.sistemasvendas.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
    , @NamedQuery(name = "Produto.findByEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.estoqueMinimo = :estoqueMinimo")
    , @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int idProduto;
    @Column(name = "estoque_minimo")
    private int estoqueMinimo;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoIdProduto")
    private List<FornecedorProduto> fornecedorProdutoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoIdProduto")
    private List<VendaProduto> vendaProdutoList;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FornecedorProduto> getFornecedorProdutoList() {
        return fornecedorProdutoList;
    }

    public void setFornecedorProdutoList(List<FornecedorProduto> fornecedorProdutoList) {
        this.fornecedorProdutoList = fornecedorProdutoList;
    }

    public List<VendaProduto> getVendaProdutoList() {
        return vendaProdutoList;
    }

    public void setVendaProdutoList(List<VendaProduto> vendaProdutoList) {
        this.vendaProdutoList = vendaProdutoList;
    }

    @Override
    public String toString() {
        return "br.com.fatecpp.sistemasvendas.model.domain.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
