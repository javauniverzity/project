package cz.expertkom.web.interfaces.repository;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;


public interface ProductRepository extends GeneralRepository<Product> {

	Product loadByProductName(String productname);

	List<Product> getListOfProducts();
	
}
