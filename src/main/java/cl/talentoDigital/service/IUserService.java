package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.User;

public interface IUserService{

	public void add(User user);
	public List<User> findAll();
	public List<User> findByEmail(String email);
}
