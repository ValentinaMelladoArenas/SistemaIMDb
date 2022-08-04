package cl.talentoDigital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Rating;
import cl.talentoDigital.repository.IRatingRepository;

@Service
public class RatingServiceImplement implements IRatingService {

	@Autowired
	IRatingRepository dao;
	
	@Override
	public void save(Rating rating) {
		dao.save(rating);
	}

	@Override
	public List<Rating> findAll() {
		return (List<Rating>) dao.findAll();
	}

	@Override
	public void update(Rating rating) {
		dao.save(rating);
	}

	@Override
	public Optional<Rating> findById(Long idRating) {
		return dao.findById(idRating);
	}

}
