package cz.bodyplan.be.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bodyplan.web.interfaces.repository.PavelRepository;
import cz.bodyplan.web.interfaces.service.PavelService;
import cz.bodyplan.web.vo.dto.Pavel;

@Service
public class PavelServiceImpl implements PavelService {

	@Autowired
	private PavelRepository repository;

	@Override
	public Pavel loadById(Long id) {
		return repository.loadById(id);
	}

	@Override
	public void create(Pavel pavel) {
		repository.create(pavel);

	}

	@Override
	public void remove(Pavel pavel) {
		repository.remove(pavel);

	}

	@Override
	public void update(Pavel pavel) {
		repository.update(pavel);

	}

}
