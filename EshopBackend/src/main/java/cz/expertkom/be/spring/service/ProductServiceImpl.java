package cz.expertkom.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.web.interfaces.repository.ProductRepository;
import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.vo.dto.Product;

/**
 * Implementace povinnych metod pro objekt produkt
 * @author David
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	/**
	 * Hledani produktu podle Id
	 */
	@Override
	public Product loadById(Long id) {
		return repository.loadById(id);
	}

	/**
	 * Hledani produktu podle jmena
	 */
	@Override
	public Product loadByProductName(String productname) {
		return repository.loadByProductName(productname);
	}

	/**
	 * Dej seznam produktu
	 */
	@Override
	public List<Product> getList() {
		return repository.getListOfProducts();
	}

	/**
	 * Snizi mnozstvi produktu na sklade o 1
	 */
	@Override
	public void decreaseQuantity(List<Long> ids) {
		for (Long id : ids) {
			Product database = repository.loadById(id);
			if (database.getQuantity() == null) {
				database.setQuantity(0);
			}
			Integer newQuantity = database.getQuantity() - 1;
			database.setQuantity(newQuantity);
			repository.update(database);
		}

	}

	@Override
	public void create(Product product) {
		repository.create(product);
		
	}
	@Override
	public void update(Product product) {
		repository.update(product);
	}

	/**
	 * Hleda produkt
	 */
	@Override
	public List<Product> searchProduct(String query) {
		return repository.searchProduct(query);
	}

	/**
	 * Seradi seznam produktu
	 */
	@Override
	public List<Product> sorter(String sortBy, String sortHow) {
		return repository.sorter(sortBy, sortHow);
	}
}
