package br.com.fatecpp.sistemasvendas.model.dao;

import br.com.fatecpp.sistemasvendas.model.domain.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VendaDAO implements DAOGenerico<Venda> {
    
    private static VendaDAO unicaInstancia;
    private EntityManager em;
    
    public static VendaDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new VendaDAO();
        }
        return unicaInstancia;
    }
    
    private VendaDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVendasPU");
        if (em == null){
            em = emf.createEntityManager();
        }
    }

    @Override
    public void inserir(Venda entidade) {
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
    public void alterar(Venda entidade) {
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
    public void excluir(Venda entidade) {
        try{
            em.getTransaction().begin();
            Venda v = em.merge(entidade);
            em.remove(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Venda> consultar(String opcao, String parametro) {
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
