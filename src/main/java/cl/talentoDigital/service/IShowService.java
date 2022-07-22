package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Show;

public interface IShowService {

	public void save(Show show);
	public void delete(Show show);
	public List<Show> findAll();
}
