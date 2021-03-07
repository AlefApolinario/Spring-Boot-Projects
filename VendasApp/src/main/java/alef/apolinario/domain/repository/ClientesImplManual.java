package alef.apolinario.domain.repository;


import alef.apolinario.domain.entity.ClienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ClientesImplManual {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public ClienteJPA salvar(ClienteJPA clienteJPA){
        entityManager.persist(clienteJPA);
        return clienteJPA;
    }

    @Transactional
    public ClienteJPA atualizar(ClienteJPA clienteJPA){
        entityManager.merge(clienteJPA);
        return clienteJPA;
    }

    @Transactional
    public void deletar(ClienteJPA clienteJPA){
        if(!entityManager.contains(clienteJPA)){
            clienteJPA = entityManager.merge(clienteJPA);
        }
        entityManager.remove(clienteJPA);
    }

    @Transactional
    public void deletar(Integer id){
        ClienteJPA clienteJPA = entityManager.find(ClienteJPA.class, id);
        deletar(clienteJPA);
    }
    @Transactional(readOnly = true)
    public List<ClienteJPA> buscarPorNome(String nome) {
        String jpql = "select c from ClienteJPA c where c.nome like :nome";
        TypedQuery<ClienteJPA> query = entityManager.createQuery(jpql, ClienteJPA.class);
        query.setParameter("nome",  "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<ClienteJPA> obterTodos(){
        return entityManager
                .createQuery("from ClienteJPA", ClienteJPA.class)
                .getResultList();
    }

    }

