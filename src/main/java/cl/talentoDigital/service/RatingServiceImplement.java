package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Rating;
import cl.talentoDigital.repository.IRatingRepository;

@Service
public class RatingServiceImplement implements IRatingService {

	@Autowired
	IRatingRepository dao;
	
	@Override
	public void save(String rating) {
		dao.save(rating);
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
