package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Show;
import cl.talentoDigital.repository.IShowRepository;

@Service
public class ShowServiceImplement implements IShowService {

	@Autowired
	IShowRepository dao;
	
	@Override
	public void save(Show show) {
		dao.save(show);
	}

	@Override
	public void delete(Show show) {
		dao.delete(show);
	}

	@Override
	public List<Show> findAll() {
		return (List<Show>) dao.findAll();
	}

	@Override
	public List<Show> findByShowTitle(String showTitle) {
		return (List<Show>) dao.findByShowTitleLike(showTitle);
	}

	@Override
	public void update(Show show) {
		dao.save(show);
	}

	@Override
	public void findById(Long idShow) {
		dao.findById(idShow);
	}

}
