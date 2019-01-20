package com.munifbadr.Service;

import com.munifbadr.Dtos.UsersDto;
import com.munifbadr.Entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity Create(UsersDto users);

    public ResponseEntity Update(UsersDto users, Long id);

    public ResponseEntity Delete(Long id);

    public UsersDto FindById(Long id);

    public List<UsersDto> FindAll();

    Users findbyname(String string);
}
