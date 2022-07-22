package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Usuario;

public interface IUsuarioService{

	public void add(Usuario usuario);
	public List<Usuario> findAll();
	public List<Usuario> findByEmail(String email);
}
