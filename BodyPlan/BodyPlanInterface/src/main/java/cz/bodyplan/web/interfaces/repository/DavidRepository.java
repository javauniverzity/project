package cz.bodyplan.web.interfaces.repository;

import java.util.List;

import cz.bodyplan.web.vo.dto.User;

public interface DavidRepository extends GeneralRepository<Object>{

    User loadUserByUsername(String username);

    List<User> getListOfUsers();

    }
