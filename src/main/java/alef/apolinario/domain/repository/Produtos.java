package alef.apolinario.domain.repository;

import alef.apolinario.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
    
}
