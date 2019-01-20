package com.munifbadr.Controllers;

import com.munifbadr.Service.ServiceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/userData")
    public ResponseEntity login(Principal principal){
        Map<String,String> map= new HashMap<>();
        map.put("id",String.valueOf(userServiceImp.findbyname(principal.getName()).getId()));
        map.put("role",userServiceImp.findbyname(principal.getName()).getRoles().getRole_name());
        return ResponseEntity.ok(map);
    }

}
