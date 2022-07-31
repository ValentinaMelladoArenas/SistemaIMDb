package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Role;

public interface IRoleService {

	public List<Role> findAll();
	public void save(Role role);
	public void update(Role role);
	public void findById(Long idRole);
}
