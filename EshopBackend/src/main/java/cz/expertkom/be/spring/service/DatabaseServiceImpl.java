package cz.expertkom.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.web.interfaces.repository.DatabaseRepository;
import cz.expertkom.web.interfaces.service.DatabaseService;
import cz.expertkom.web.vo.dto.Database;

public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	DatabaseRepository repository;
	
	
	@Override
	public Database loadById(Long id) {
		
		return repository.loadById(id);
	}
	@Override
	public Database loadByProductName(String productname) {
		
		return repository.loadByProductName(productname);
	} 
	
// TODO pokud chcete nechat loadByPrice a podobn�, je t�eba to zav�st do repository, tak�e pros�m o domluvu a �pravu
	/*
	@Override
	public Database loadByPrice(int price) {
		
		return null;
	}

	@Override
	public Database loadByCategory(String category) {
		
		return null;
	}

	@Override
	public void create(Database zaznam) {
		
		
	}
	*/
	@Override
	public List<Database> getList() {
		
		return repository.getListOfProducts();
	}


}
