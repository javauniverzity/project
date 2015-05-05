package cz.expertkom.web.interfaces.service;

import java.util.List;

import cz.expertkom.web.vo.dto.Database;

public interface DatabaseService {

    public Database loadById(long id);
    public Database loadByProductName(String ProductName);
    public Database loadByPrice(int Price);
    public Database loadByCategory(int Category);

    public void create(Database zaznam);
    
    public List<Database> getList();
}
