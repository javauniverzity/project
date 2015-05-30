package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;

/**
 * Pøedpis povinných metod pro objekt produktu
 */

public interface ProductService {

	/**
	 * Naèti produkt dle jeho jedineèného ID 
	 */
	public Product loadById(Long id);

	/**
	 * Naèti produkt dle jeho názvu
	 */
	public Product loadByProductName(String productname);

	/**
	 * Naèti všechny produkty v systému
	 */
	public List<Product> getList();

	/**
	 * Vytvoø produkt
	 */
	public void create(Product product);

	/**
	 * Aktualizuj produkt
	 */
	void update(Product product);

	/**
	 * Naèti seznam produktù dle dodaného øetìzce
	 */
	public List<Product> searchProduct(String query);

	/**
	 * Naèti produkty seøazené dle dodaných Stringových kriterií
	 */
	public List<Product> sorter(String sortBy, String sortHow);

	/**
	 * Sniž poèet skladových zásob dle seznamu IDèek produktù
	 */
	void decreaseQuantity(List<Long> ids);
}
