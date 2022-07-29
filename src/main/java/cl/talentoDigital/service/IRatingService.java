package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Rating;

public interface IRatingService {

	public List<Rating> findAll();
	public void save(Rating rating);
	public void update(Rating rating);
	public void findById(Long idRating);
}
