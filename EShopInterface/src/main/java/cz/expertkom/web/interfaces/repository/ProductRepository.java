package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * Metody pro repository produkt�
 */

public interface ProductRepository extends GeneralRepository<Product> {

	/**
	 * Na�ti produkt dle jeho n�zvu
	 */
	Product loadByProductName(String productname);

	/**
	 * Na�ti seznam v�ech produkt� syt�mu
	 */
	List<Product> getListOfProducts();

	/**
	 * Na�ti seznam produkt� dle dodan�ho �et�zce
	 */
	List<Product> searchProduct(String query);
	
	/**
	 * Na�ti produkty a se�a� je dle po�adovn�ch krit�ri�
	 */
	List<Product> sorter(String sortBy, String sortHow);
	
}
