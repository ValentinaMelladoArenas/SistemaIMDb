package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.Usuario;


public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findByEmailLike(String email);
}
