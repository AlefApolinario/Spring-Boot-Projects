package alef.apolinario.gestaofesta.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alef.apolinario.gestaofesta.model.entity.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long>{
	
}
