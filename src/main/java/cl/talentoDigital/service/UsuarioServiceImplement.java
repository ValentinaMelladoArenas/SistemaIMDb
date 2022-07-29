package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Usuario;
import cl.talentoDigital.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

	@Autowired
	IUsuarioRepository dao;
	
	@Override
	public void save(Usuario usuario) {
		dao.save(usuario);
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
	public void findById(Long idUsuario) {
		dao.findById(idUsuario);
	}

	@Override
	public List<Usuario> findByEmailLike(String email) {
		return (List<Usuario>) dao.findByEmailLike(email);
	}

}
