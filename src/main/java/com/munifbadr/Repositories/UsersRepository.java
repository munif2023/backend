package com.munifbadr.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.munifbadr.Entity.Users;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {
     Users findByUsername(String username);

     List<Users> findAll();




}
