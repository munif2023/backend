package com.munifbadr.Controllers;

import com.munifbadr.Dtos.UsersDto;
import com.munifbadr.Service.ServiceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(method = RequestMethod.POST,value = "/user/add")
    public void Create(@RequestBody @Valid UsersDto users){
        userServiceImp.Create(users);
    }

    @PutMapping("/user/update/{id}")
     void update(@RequestBody  @Valid UsersDto users,@Valid@PathVariable Long id) {
        userServiceImp.Update(users,id);
    }


    @GetMapping("/user/{id}")
     UsersDto find(@Valid@PathVariable Long id){
        return userServiceImp.FindById(id);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN')" )
    List<UsersDto> findAll() {
        return userServiceImp.FindAll();

    }

}

