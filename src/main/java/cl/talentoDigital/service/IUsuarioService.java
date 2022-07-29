package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Usuario;

public interface IUsuarioService{

	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public void findById(Long idUsuario);
	public List<Usuario> findByEmailLike(String email);
}
