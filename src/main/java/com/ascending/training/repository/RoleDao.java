package com.ascending.training.repository;

import com.ascending.training.model.Role;


public interface RoleDao {
        boolean save(Role role);
        Role findByName(String name);
}
