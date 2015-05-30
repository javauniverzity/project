package cz.expertkom.web.vo.dto;

import java.io.Serializable;

/**
 * P�edpis povinn�ch vlastnost� ka�d�ho produktu
 */

public class Product implements Serializable {

	private static final long serialVersionUID = 1420484628912894636L;

	/**
	 * Jedine�n� ID produktu
	 */
	private Long id;
	
	/**
	 * Jm�no produktu
	 */
	private String productname;
	
	/**
	 * Za�azen� do kategorie zbo��
	 */
	private String category;
	
	/**
	 * Podrobn� popis produktu
	 */
	private String description;
	
	/**
	 * Fotografie produktu
	 */
	private String image;

	/**
	 * Cena produktu
	 */
	private Integer price;

	/**
	 * Mno�stv� produkt� na sklad�
	 */
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
