package cl.talentoDigital.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Role;
import cl.talentoDigital.model.Usuario;
import cl.talentoDigital.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService, UserDetailsService  {

	@Autowired
	IUsuarioRepository dao;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	
	
	
	 public UsuarioServiceImplement(IUsuarioRepository userRepository) {
	        super();
	        this.dao = userRepository;
	    }
	
	@Override
	public void save(Usuario usuario) {
		
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		
		dao.save(new Usuario(null, usuario.getUserName(),usuario.getEmail(), 
				encodedPassword, encodedPassword, usuario.getRole(),true)
				);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) dao.findAll();
	}

	@Override
	public void update(Usuario usuario) {
		dao.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		dao.delete(usuario);
	}

	@Override
	public List<Usuario> findByEmailLike(String email) {
		return (List<Usuario>) dao.findByEmailLike(email);
	}
	


	@Override
	public Optional<Usuario> findByUsername(String username) {
		return dao.findByUserName(username);
		
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Usuario> user = dao.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}

 

}
