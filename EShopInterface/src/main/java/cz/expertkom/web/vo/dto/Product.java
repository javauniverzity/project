package cz.expertkom.web.vo.dto;

import java.io.Serializable;

/**
 * Pøedpis povinných vlastností každého produktu
 * 
 * @author Honza
 */

public class Product implements Serializable {

	private static final long serialVersionUID = 1420484628912894636L;

	/**
	 * Jedineèné ID produktu
	 */
	private Long id;

	/**
	 * Jméno produktu
	 */
	private String productname;

	/**
	 * Zaøazení do kategorie zboží
	 */
	private String category;

	/**
	 * Podrobný popis produktu
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
	 * Množství produktù na skladì
	 */
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(final String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(final String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}
}
