package br.com.fatecpp.sistemasvendas.model.dao;

import br.com.fatecpp.sistemasvendas.model.domain.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO implements DAOGenerico<Cliente> {

    private static ClienteDAO unicaInstancia;
    private EntityManager em;//é um objeto que ira gerenciar as entidades
            
    public static ClienteDAO getUnicaInstancia(){
        if(unicaInstancia == null){
            unicaInstancia = new ClienteDAO();
        }
        return unicaInstancia;
    }
    
    
    private ClienteDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaVendasPU");
        if (em == null){
            em = emf.createEntityManager();
        }
    }
    
    @Override
    public void inserir(Cliente entidade) {
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
    public void alterar(Cliente entidade) {
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
    public void excluir(Cliente entidade) {
        try{
            em.getTransaction().begin();
            Cliente c = em.merge(entidade);
            em.remove(entidade);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Cliente> consultar(String opcao, String parametro) {
        //A variável opcao foi criada apenas para poder diferenciar
        //qual tipo de consulta queremos fazer

        //A variável q armazena o resultado da consulta
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
