package cz.bodyplan.be.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cz.bodyplan.web.interfaces.repository.DavidRepository;
import cz.bodyplan.web.interfaces.service.DavidService;
import cz.bodyplan.web.vo.dto.David;

@Service
public class DavidServiceImpl implements DavidService {

    @Autowired
    private DavidRepository repository;

    @Override
    public David loadById(Long id) {
        return repository.loadById(id);
    }

    @Override
    public void create(David david) {
        repository.create(david);

    }

    @Override
    public void remove(David david) {
        repository.remove(david);

    }

    @Override
    public void update(David david) {
        repository.update(david);

    }

    @Override
    public UserDetails loadUserByUsername(String arg0)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<David> getList() {
        // TODO Auto-generated method stub
        return null;
    }

}
