package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Role;
import cl.talentoDigital.repository.IRoleRepository;

@Service
public class RoleServiceImplement implements IRoleService {

	@Autowired
	IRoleRepository dao;
	
	@Override
	public List<Role> findAll() {
		return (List<Role>) dao.findAll();
	}

	@Override
	public void save(Role role) {
		dao.save(role);
	}

	@Override
	public void update(Role role) {
		dao.save(role);
	}

	@Override
	public void findById(Long idRole) {
		dao.findById(idRole);
	}

}
