package com.ascending.training.repository;

import com.ascending.training.model.Role;


public class RoleDaoImpl implements RoleDao{
    @Override
    public boolean save(Role role) {
        return false;
    }

    @Override
    public Role findByName(String name) {
        String hql = "FROM roles r where r.name=:name";
        return null;
    }

}
