package br.com.fatecpp.sistemasvendas.model.dao;

import br.com.fatecpp.sistemasvendas.model.domain.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FornecedorDAO implements DAOGenerico<Fornecedor> {

    private static FornecedorDAO unicaInstancia;
    private EntityManager em;//é um objeto que ira gerenciar as entidades
    
    public static FornecedorDAO getUnicaInstancia(){
        if (unicaInstancia == null){
            unicaInstancia = new FornecedorDAO();
        }
        return unicaInstancia;
    }
    
    private FornecedorDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVendasPU");
        if (em == null){
            em = emf.createEntityManager();
        }
    }
    
    @Override
    public void inserir(Fornecedor entidade) {
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
    public void alterar(Fornecedor entidade) {
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
    public void excluir(Fornecedor entidade) {
        try{
            em.getTransaction().begin();
            Fornecedor f = em.merge(entidade);
            em.remove(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Fornecedor> consultar(String opcao, String parametro) {
        Query q = null;
        if (opcao.equals("consultarTodos")) {
        q = em.createNamedQuery("Cliente.findAll");
        } else if (opcao.equals("consultarPorId")){
        q = em.createNamedQuery("Cliente.findByIdCliente");
        q.setParameter(":idCliente", parametro);
        } else if (opcao.equals("consultarPorNome")){
        q = em.createNamedQuery("Cliente.findByNome");
        q.setParameter(":nome", "%" + parametro + "%");
        } else if (opcao.equals("consultarPorEmail")){
        q = em.createNamedQuery("Cliente.findByEmail");
        q.setParameter(":email", "%" + parametro + "%");
        }
        return q.getResultList();
    }
    
}
