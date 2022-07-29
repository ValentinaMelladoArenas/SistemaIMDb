package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Show;

public interface IShowService {

	public List<Show> findAll();
	public List<Show> findByName(String showName);
	public void save(Show show);
	public void delete(Show show);
	public void update(Show show);
	public void findById(Long idShow);
}
