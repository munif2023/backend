//package com.munifbadr.Service.ServiceImp;
//
//import com.munifbadr.Entity.Roles;
//import com.munifbadr.Entity.UserRole;
//import com.munifbadr.Entity.Users;
//import com.munifbadr.Repositories.RolesRepository;
//import com.munifbadr.Repositories.UserRoleRepository;
//import com.munifbadr.Repositories.UsersRepository;
//import com.munifbadr.Service.UserRoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserRoleServiceImp implements UserRoleService {
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//    @Autowired
//    private UsersRepository usersRepository;
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @Override
//    public ResponseEntity Create(Long userid, Long roleid) {
//        UserRole userRole=new UserRole();
//        Optional<Users> users=usersRepository.findById(userid);
//        Optional<Roles> roles=rolesRepository.findById(roleid);
//        if (!users.isPresent())
//            return ResponseEntity.badRequest().build();
//        if (!roles.isPresent())
//            return  ResponseEntity.notFound().build();
//
//        userRole.setUsers(usersRepository.findById(userid).get());
//        userRole.setRoles(rolesRepository.findById(roleid).get());
//        userRoleRepository.save(userRole);
//
//        return null;
//    }
//
//    @Override
//    public void Update(UserRole user ,Long id) {
//        Optional  <UserRole> userRole= userRoleRepository.findById(id);
//        if (userRole.isPresent())
//        userRoleRepository.save(user);
//    }
//
//    @Override
//    public void Delete(Long id) {
//        Optional <UserRole> userRole= userRoleRepository.findById(id);
//        if(userRole.isPresent()) {
//            userRole.get().setDflag(true);
//            userRoleRepository.save(userRole.get());
//        }else return;
//    }
//
//    @Override
//    public ResponseEntity<UserRole> FindById(Long id) {
//        Optional<UserRole> users=userRoleRepository.findById(id);
//
//        if (users.isPresent()&&!users.get().isDflag()) {
//            return ResponseEntity.accepted().body(users.get());
//        }
//
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @Override
//    public List<UserRole> FindAll() {
//        List<UserRole> Result= new ArrayList<>();
//        for(UserRole result:userRoleRepository.findAll())
//            if(!result.isDflag())
//                Result.add(result);
//        return Result;
//    }
//
//}
