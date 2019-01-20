package com.munifbadr.Controllers;

import com.munifbadr.Entity.Roles;
import com.munifbadr.Service.ServiceImp.RolesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RolesController {


    @Autowired
    private RolesServiceImp rolesServiceImp;


    @GetMapping(value = "/roles")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN')" )
    List<Roles> findAll() {
     return rolesServiceImp.FindAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/roles/Save")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN')" )
     void save(@Valid@RequestBody Roles roles){
        rolesServiceImp.Create(roles);
    }
}

