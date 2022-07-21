package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.User;

public interface IUserRepository extends CrudRepository<User, Long> {

	@Query("FROM User WHERE email like %?1%")
	public List<User> findByEmail(String email);
}
