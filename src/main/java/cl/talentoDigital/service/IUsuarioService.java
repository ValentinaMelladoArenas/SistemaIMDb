package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Usuario;

public interface IUsuarioService{

	public void save(Usuario usuario);
	public List<Usuario> findAll();
	public List<Usuario> findByEmail(String email);
}
