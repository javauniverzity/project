package cz.expertkom.web.vo.dto;

import java.io.Serializable;

public class Database implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1420484628912894636L;
	private Long id;
	private String productname;
	private String category;
	private String description;
	private String image;
	private Integer price;
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
	
	// TODO p�epsala jsem Davidovu t��du Database, aby sed�la se v�emi hotov�mi repository a service, jetsli n�co, klidn� p�epsat zp�tky
}
