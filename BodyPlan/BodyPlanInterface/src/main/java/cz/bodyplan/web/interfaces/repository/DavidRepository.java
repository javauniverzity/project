package cz.bodyplan.web.interfaces.repository;

import java.util.List;

import cz.bodyplan.web.vo.dto.David;
import cz.bodyplan.web.vo.dto.User;

public interface DavidRepository extends GeneralRepository<David>{

    User loadUserByUsername(String username);

    List<User> getListOfUsers();

    }
