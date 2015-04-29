package cz.bodyplan.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bodyplan.web.interfaces.repository.MarekRepository;
import cz.bodyplan.web.interfaces.service.MarekService;
import cz.bodyplan.web.vo.dto.Marek;


@Service
public class MarekServiceImpl implements MarekService{

	@Autowired
	private MarekRepository repository;
	
	@Override
	public Marek loadById(Long id) {
		
		return repository.loadById(id);
	}

	@Override
	public void create(Marek marek) {
		repository.create(marek);
		
		
	}

	@Override
	public void remove(Marek marek) {
		repository.remove(marek);
		
	}

	@Override
	public void update(Marek marek) {
		repository.update(marek);
		
	}

	@Override
	public List<Marek> getList() {
		return repository.getListOfMareks();

	}
}