package com.munifbadr.Service;

import com.munifbadr.Entity.Roles;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RolesService {
    public void Create(Roles roles);

    public void Update(Roles roles, String id);

    public void Delete( String id);

    public ResponseEntity<Object> FindById(String id);

    public List<Roles> FindAll();
}
