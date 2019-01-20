package com.munifbadr.Controllers;

import com.munifbadr.Entity.Rate;
import com.munifbadr.Service.ServiceImp.RateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/api")
@RestController
public class RateController {

@Autowired
    private RateServiceImp rateServiceImp;

    @GetMapping("/rate")
    private List<Rate> findall(){
        return rateServiceImp.find();
}

    @PostMapping("/rate/{id}")
    private void Create (@Valid @PathVariable Long id){
        rateServiceImp.Create(id);
    }

    @PostMapping("/review/{ticketid}")
    @PreAuthorize( "hasRole('ROLE_USER')" )
    public ResponseEntity<Rate> rate(@RequestBody Rate rate,@PathVariable Long ticketid){
        return rateServiceImp.rate(rate,ticketid);
    }

}
