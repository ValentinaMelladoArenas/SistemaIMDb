package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Usuario;

public interface IUserService{

	public void add(Usuario user);
	public List<Usuario> findAll();
	public List<Usuario> findByEmail(String email);
}
