package cl.talentoDigital.service;

import java.util.List;
import java.util.Optional;

import cl.talentoDigital.model.Rating;

public interface IRatingService {

	public List<Rating> findAll();
	public void save(Rating rating);
	public void update(Rating rating);
	public Optional<Rating> findById(Long idRating);
	public boolean findUsuarioRating(Long showId, Long usuarioId);
}
