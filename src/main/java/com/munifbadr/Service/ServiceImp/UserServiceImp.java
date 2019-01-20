package com.munifbadr.Service.ServiceImp;


import com.munifbadr.Dtos.UsersDto;
import com.munifbadr.Entity.Roles;
import com.munifbadr.Entity.Users;
import com.munifbadr.Repositories.RolesRepository;
import com.munifbadr.mapping.ObjectMapperUtils;
import com.munifbadr.Repositories.UsersRepository;
import com.munifbadr.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;

     @Autowired
     private ModelMapper modelMapper;

    @Override
    public ResponseEntity Create(UsersDto users) {
       users.setRoles(rolesRepository.findByRolename(users.getRole()));

        Users users1=modelMapper.map(users,Users.class);
        String encoded=new BCryptPasswordEncoder().encode(users1.getPassword());
        users1.setPassword(encoded);
        if (users1.getUsername().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        usersRepository.save(users1);
        return ResponseEntity.ok().body(users1);

    }

    @Override
    public ResponseEntity Update(UsersDto user , Long id) {
         Users users=  usersRepository.findById(id).get();
       if (usersRepository.findById(id).isPresent()) {
         Users users1=  modelMapper.map(user,Users.class);
         users1.setId(id);
         users1.setRoles(users.getRoles());
           usersRepository.save(users1);
           return ResponseEntity.ok(users1);
       }
       return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity Delete(Long id) {
        Optional  <Users> users=usersRepository.findById(id);
        if (users.isPresent()){
            if (users.get().isD_Flag()==false) {
                users.get().setD_Flag(true);
                ResponseEntity.ok().build();
                usersRepository.save(users.get());
            }

        }return ResponseEntity.notFound().build();
    }

    @Override
    public UsersDto FindById(Long id) {

       Users users=usersRepository.findById(id).get();

       // if (users.isPresent()&&!users.get().isD_Flag()) {
            UsersDto usersDto=modelMapper.map(users,UsersDto.class);
            return usersDto;
        }





    @Override
    public List<UsersDto> FindAll() {

        List<Users> users= usersRepository.findAll();
        List<UsersDto> usersDtos=ObjectMapperUtils.mapAll(users,UsersDto.class);
        return usersDtos;
    }

    @Override
    public Users findbyname(String string) {
       return usersRepository.findByUsername(string);
    }

}
