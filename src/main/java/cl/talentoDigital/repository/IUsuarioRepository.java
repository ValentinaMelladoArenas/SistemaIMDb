package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("FROM User WHERE email like %?1%")
	public List<Usuario> findByEmail(String email);
}
