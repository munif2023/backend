package com.munifbadr.Service.ServiceImp;

import com.munifbadr.Entity.Roles;
import com.munifbadr.Repositories.RolesRepository;
import com.munifbadr.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImp implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public void Create(Roles roles) {
        rolesRepository.save(roles);

    }

    @Override
    public void Update(Roles roles ,String id) {
        Optional<Roles> role=rolesRepository.findById(id);
        if (role.isPresent())
        rolesRepository.save(roles);
    }

    @Override
    public void Delete(String id) {
        Optional<Roles> roles=rolesRepository.findById(id);
        if (roles.isPresent()) {
            roles.get().setDflag(true);
            rolesRepository.save(roles.get());
        }else return;
    }

    @Override
    public ResponseEntity<Object> FindById(String id) {
        Optional<Roles> users = rolesRepository.findById(id);

        if (users.isPresent() && !users.get().isDflag()) {
            return ResponseEntity.accepted().body(users.get());
        }


        return ResponseEntity.notFound().build();
    }
    @Override
    public List<Roles> FindAll() {
        List<Roles> Result= new ArrayList<>();
        for(Roles result:rolesRepository.findAll())
            if(!result.isDflag())
        Result.add(result);

        return Result;
    }
}
