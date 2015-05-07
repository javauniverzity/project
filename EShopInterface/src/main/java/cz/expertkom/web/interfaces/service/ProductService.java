package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Product;


public interface ProductService {
	
    public Product loadById(Long id);
    public Product loadByProductName(String productname);
    /* TODO poopraveno ale doèasnì v komentáøi. viz ServiceImpl
    public Database loadByPrice(Integer price);
    public Database loadByCategory(String category);

    public void create(Database zaznam);
    */
    
    void decreaseQuantity (List<Long> ids);
    
    
    public List<Product> getList();
}
