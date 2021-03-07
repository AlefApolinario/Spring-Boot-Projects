package alef.apolinario.domain.repository;


import alef.apolinario.domain.entity.ClienteJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<ClienteJPA, Integer> {

    List<ClienteJPA> findByNomeLike(String clienteJPA);

    @Query(value = "select c from ClienteJPA c where c.id = :id")
    List<ClienteJPA> encontrarPorId(@Param("id") Integer id);

    @Query(value = "delete from ClienteJPA c where c.id = :id")
    @Modifying
    void deleteByNome(@Param("id") Integer id);

    boolean existsByNome(String nome);

    @Query("select c from ClienteJPA c left join fetch c.pedidos where c.id = :id")
    ClienteJPA findClienteJPAFetchPedidos(@Param("id") Integer id);


}

