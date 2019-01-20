package com.munifbadr.Repositories;

import com.munifbadr.Entity.Rate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RateRepository extends CrudRepository <Rate ,Long> {

    List<Rate> findAll();

}
