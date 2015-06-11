package cz.expertkom.be.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import cz.expertkom.web.interfaces.repository.ProductRepository;
import cz.expertkom.web.vo.dto.Product;

/**
 * Implementace repository pro produkt.
 *
 * @author Honza
 */
@Repository
public class ProductRepositoryImpl extends GeneralRepository<Product> implements ProductRepository {

	/**
	 * Nacteni produktu podle Id.
	 *
	 * @return produkt
	 */
	@Override
	public Product loadById(final Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);
		crit.select(products).where(criteriaBuilder.equal(products.get("id"), id));

		final List<Product> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

	/**
	 * Nacteni produktu podle nazvu produktu.
	 *
	 * @return produkt
	 */
	@Override
	public Product loadByProductName(final String productname) {
		if (productname == null || "".equals(productname)) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);
		crit.select(products).where(criteriaBuilder.equal(products.get("productname"), productname));

		final List<Product> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

	/**
	 * Vypis vsech produktu.
	 *
	 * @return list produktu
	 */
	@Override
	public List<Product> getListOfProducts() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Product> createQuery = criteriaBuilder.createQuery(Product.class);
		final CriteriaQuery<Product> select = createQuery.select(createQuery.from(Product.class));
		return findByCriteria(select);
	}

	/**
	 * Vyhledej produkty obsahujici retezec v nazvu ci popisu.
	 *
	 * @return list produktu
	 */
	@Override
	public List<Product> searchProduct(final String query) {
		if (query == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);

		crit.select(products).where(criteriaBuilder.or(criteriaBuilder.like(products.get("productname"), "%" + query + "%"), criteriaBuilder.like(products.get("description"), "%" + query + "%")));

		final List<Product> results = findByCriteria(crit);
		return results;
	}

	/**
	 * Nacti list produktu podle kriterii.
	 *
	 * @return list produktu
	 */
	@Override
	public List<Product> sorter(final String sortBy, final String sortHow) {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);

		if (sortBy.equals("productname")) {
			if (sortHow.equals("asc")) {
				crit.select(products).orderBy(criteriaBuilder.asc(products.get("productname")));
			} else {
				crit.select(products).orderBy(criteriaBuilder.desc(products.get("productname")));
			}
		} else if (sortBy.equals("price")) {
			if (sortHow.equals("asc")) {
				crit.select(products).orderBy(criteriaBuilder.asc(products.get("price")));
			} else {
				crit.select(products).orderBy(criteriaBuilder.desc(products.get("price")));
			}
		}

		final List<Product> results = findByCriteria(crit);
		return results;
	}
}
