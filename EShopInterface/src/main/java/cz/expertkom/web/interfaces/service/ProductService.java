package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * P�edpis povinn�ch metod pro objekt produktu
 */

public interface ProductService {

	/**
	 * Na�ti produkt dle jeho jedine�n�ho ID 
	 */
	public Product loadById(Long id);

	/**
	 * Na�ti produkt dle jeho n�zvu
	 */
	public Product loadByProductName(String productname);

	/**
	 * Na�ti v�echny produkty v syst�mu
	 */
	public List<Product> getList();

	/**
	 * Vytvo� produkt
	 */
	public void create(Product product);

	/**
	 * Aktualizuj produkt
	 */
	void update(Product product);

	/**
	 * Na�ti seznam produkt� dle dodan�ho �et�zce
	 */
	public List<Product> searchProduct(String query);

	/**
	 * Na�ti produkty se�azen� dle dodan�ch Stringov�ch kriteri�
	 */
	public List<Product> sorter(String sortBy, String sortHow);

	/**
	 * Sni� po�et skladov�ch z�sob dle seznamu ID�ek produkt�
	 */
	void decreaseQuantity(List<Long> ids);
}
