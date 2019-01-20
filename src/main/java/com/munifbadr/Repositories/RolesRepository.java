package com.munifbadr.Repositories;


import com.munifbadr.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,String> {
    Roles findByRolename(String rolename);
}
