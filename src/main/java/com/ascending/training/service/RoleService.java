package com.ascending.training.service;

import com.ascending.training.model.Role;
import com.ascending.training.repository.RoleDao;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired private Logger logger;
    @Autowired private RoleDao roleDao;

    public boolean save(Role r) {
       return roleDao.save(r);
    }

    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }


}
