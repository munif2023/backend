//package com.munifbadr.Entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "USERROLE")
//public class UserRole {
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column (name = "DFLAG",nullable = false,columnDefinition = "int default 0")
//    private boolean Dflag;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USERS",referencedColumnName = "UserID")
//    private Users users;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ROLES",referencedColumnName = "ID")
//    private Roles roles;
//
//    public boolean isDflag() {
//        return Dflag;
//    }
//
//    public void setDflag(boolean dflag) {
//        Dflag = dflag;
//    }
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }
//
//    public Roles getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Roles roles) {
//        this.roles = roles;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//}
