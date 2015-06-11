package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * Metody pro repository produkt�.
 *
 * @author Honza
 */

public interface ProductRepository extends GeneralRepository<Product> {

	/**
	 * Na�ti produkt dle jeho n�zvu.
	 *
	 * @return produkt
	 */
	Product loadByProductName(String productname);

	/**
	 * Na�ti seznam v�ech produkt� syst�mu.
	 *
	 * @return list produktu
	 */
	List<Product> getListOfProducts();

	/**
	 * Na�ti seznam produkt� dle dodan�ho �et�zce.
	 *
	 * @return list produktu
	 */
	List<Product> searchProduct(String query);

	/**
	 * Na�ti produkty a se�a� je dle po�adovan�ch krit�ri�.
	 *
	 * @return list produktu
	 */
	List<Product> sorter(String sortBy, String sortHow);

}
