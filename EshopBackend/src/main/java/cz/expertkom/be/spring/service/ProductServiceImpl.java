package cz.expertkom.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.web.interfaces.repository.ProductRepository;
import cz.expertkom.web.interfaces.service.ProductService;
import cz.expertkom.web.vo.dto.Product;

/**
 * Implementace povinnych metod pro objekt produkt.
 *
 * @author Honza
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	/**
	 * Nacteni produktu podle Id.
	 *
	 * @return produkt
	 */
	@Override
	public Product loadById(final Long id) {
		return repository.loadById(id);
	}

	/**
	 * Nacteni produktu podle jmena.
	 *
	 * @return produkt
	 */
	@Override
	public Product loadByProductName(final String productname) {
		return repository.loadByProductName(productname);
	}

	/**
	 * Nacti seznam vsech produktu.
	 *
	 * @return list produktu
	 */
	@Override
	public List<Product> getList() {
		return repository.getListOfProducts();
	}

	/**
	 * Snizi mnozstvi produktu podle ids na sklade o 1.
	 */
	@Override
	public void decreaseQuantity(final List<Long> ids) {
		for (final Long id : ids) {
			final Product database = repository.loadById(id);
			if (database.getQuantity() == null) {
				database.setQuantity(0);
			}
			final Integer newQuantity = database.getQuantity() - 1;
			database.setQuantity(newQuantity);
			repository.update(database);
		}
	}

	/**
	 * Vytvor produkt.
	 */
	@Override
	public void create(final Product product) {
		repository.create(product);

	}

	/**
	 * Aktualizuj produkt.
	 */
	@Override
	public void update(final Product product) {
		repository.update(product);
	}

	/**
	 * Nacti produkt obsahujici retezec.
	 *
	 * @return list produktu
	 */
	@Override
	public List<Product> searchProduct(final String query) {
		return repository.searchProduct(query);
	}

	/**
	 * Nacti seznam produktu sereazeny podle kriterii.
	 *
	 * @return the list
	 */
	@Override
	public List<Product> sorter(final String sortBy, final String sortHow) {
		return repository.sorter(sortBy, sortHow);
	}

}
