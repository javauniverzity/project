package cz.expertkom.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.web.interfaces.repository.DatabaseRepository;
import cz.expertkom.web.interfaces.service.DatabaseService;
import cz.expertkom.web.vo.dto.Database;

@Service
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

	// TODO pokud chcete nechat loadByPrice a podobn�, je t�eba to zav�st do
	// repository, tak�e pros�m o domluvu a �pravu
	/*
	 * @Override public Database loadByPrice(int price) {
	 * 
	 * return null; }
	 * 
	 * @Override public Database loadByCategory(String category) {
	 * 
	 * return null; }
	 * 
	 * @Override public void create(Database zaznam) {
	 * 
	 * 
	 * }
	 */
	@Override
	public List<Database> getList() {

		return repository.getListOfProducts();
	}

	@Override
	public void decreaseQuantity(List<Long> ids) {
		for (Long id : ids) {
			Database database = repository.loadById(id);
			if (database.getQuantity() == null) {
				database.setQuantity(0);
			}
			Integer newQuantity = database.getQuantity() - 1;
			database.setQuantity(newQuantity);
			repository.update(database);
		}

	}

}
