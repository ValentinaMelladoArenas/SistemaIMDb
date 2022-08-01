package cl.talentoDigital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import cl.talentoDigital.model.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByEmailLike(String email);
	Optional<Usuario> findByUserName(String username);
}
