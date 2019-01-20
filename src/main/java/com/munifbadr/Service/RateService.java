package com.munifbadr.Service;

import com.munifbadr.Entity.Rate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RateService {

    public void Create( Long id);

    public void Update(Rate rate, Long id);

    public void Delete( Long id);

    public List<Rate> find();

    ResponseEntity<Rate> rate(Rate rate,Long id);


}
