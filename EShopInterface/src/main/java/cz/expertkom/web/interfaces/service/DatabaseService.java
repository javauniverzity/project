package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Database;

public interface DatabaseService {
	
    public Database loadById(Long id);
    public Database loadByProductName(String productname);
    /* TODO poopraveno ale doèasnì v komentáøi. viz ServiceImpl
    public Database loadByPrice(Integer price);
    public Database loadByCategory(String category);

    public void create(Database zaznam);
    */
    public List<Database> getList();
}
