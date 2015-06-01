package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * Metody pro repository produktù
 */

public interface ProductRepository extends GeneralRepository<Product> {

	/**
	 * Naèti produkt dle jeho názvu
	 */
	Product loadByProductName(String productname);

	/**
	 * Naèti seznam všech produktù sytému
	 */
	List<Product> getListOfProducts();

	/**
	 * Naèti seznam produktù dle dodaného øetìzce
	 */
	List<Product> searchProduct(String query);
	
	/**
	 * Naèti produkty a seøaï je dle požadovných kritérií
	 */
	List<Product> sorter(String sortBy, String sortHow);
	
}
