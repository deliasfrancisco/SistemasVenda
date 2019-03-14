package br.com.fatecpp.sistemasvendas.model.dao;

import br.com.fatecpp.sistemasvendas.model.domain.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProdutoDAO implements DAOGenerico<Produto> {

    private static ProdutoDAO unicaInstancia;
    private EntityManager em;

    public static ProdutoDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new ProdutoDAO();
        }
        return unicaInstancia;
    }
    
    private ProdutoDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVendasPU");
        if (em == null){
            em = emf.createEntityManager();
        }
    }

    @Override
    public void inserir(Produto entidade) {
        try{
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public void alterar(Produto entidade) {
       try{
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public void excluir(Produto entidade) {
        try{
            em.getTransaction().begin();
            Produto v = em.merge(entidade);
            em.remove(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Produto> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Produto.findAll");
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Cliente.findByNome");
        q.setParameter("nome", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Produto.findByIdProduto");
        q.setParameter("idProduto", parametro);
        }
        return q.getResultList();
    }
    
}
