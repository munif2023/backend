//package com.munifbadr.Controllers;
//
//import com.munifbadr.Entity.UserRole;
//import com.munifbadr.Repositories.UserRoleRepository;
//import com.munifbadr.Service.ServiceImp.UserRoleServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//@RestController
//public class UserRoleController {
//
//    @Autowired
//    private UserRoleServiceImp userRoleServiceImp;
//
//
//    @RequestMapping(value="/userroles", method = RequestMethod.GET)
//
//    List<UserRole> findAll(@RequestParam(required = false) String UsRo) {
//       return userRoleServiceImp.FindAll();
//    }
//
//
////    @RequestMapping(method = RequestMethod.POST,value = "/UserRoles/Save/{userid}/{roleid}")
//    @PostMapping("/UserRoles/Save/{userid}/{roleid}")
//    private void save(@PathVariable Long userid,@PathVariable Long roleid){
//        userRoleServiceImp.Create(userid,roleid);
//    }
//}
