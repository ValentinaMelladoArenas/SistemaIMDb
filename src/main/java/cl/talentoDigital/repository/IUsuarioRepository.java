package cl.talentoDigital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import cl.talentoDigital.model.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByEmailLike(String email);
	Optional<Usuario> findByUserName(String username);
}
