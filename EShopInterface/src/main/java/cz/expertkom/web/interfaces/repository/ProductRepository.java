package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * Metody pro repository produktù.
 *
 * @author Honza
 */

public interface ProductRepository extends GeneralRepository<Product> {

	/**
	 * Naèti produkt dle jeho názvu.
	 *
	 * @return produkt
	 */
	Product loadByProductName(String productname);

	/**
	 * Naèti seznam všech produktù systému.
	 *
	 * @return list produktu
	 */
	List<Product> getListOfProducts();

	/**
	 * Naèti seznam produktù dle dodaného øetìzce.
	 *
	 * @return list produktu
	 */
	List<Product> searchProduct(String query);

	/**
	 * Naèti produkty a seøaï je dle požadovaných kritérií.
	 *
	 * @return list produktu
	 */
	List<Product> sorter(String sortBy, String sortHow);

}
