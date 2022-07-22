package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Rating;

public interface IRatingService {

	public void save(Rating rating);
	public List<Rating> findAll();
}
