package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;


public interface ProductService {
	
    public Product loadById(Long id);
    public Product loadByProductName(String productname);
    
    public List<Product> searchProduct(String query);
    
    public List<Product> sorter(String sortBy, String sortHow);
    
    /* 
    public Database loadByPrice(Integer price);
    public Database loadByCategory(String category);
	*/
    public void create(Product product);
       
    void decreaseQuantity (List<Long> ids);
    
    
    public List<Product> getList();

    void update(Product product);
}
