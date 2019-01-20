package com.munifbadr.Entity;

import javax.persistence.*;

@Entity
@Table(name= "ROLES" )
public class Roles {
//    @Id
//    @Column(name="ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long roleid;
@Id
    @Column
    private String rolename;

    @Column ( nullable = false,columnDefinition = "int default 0")
    private boolean Dflag;

    public boolean isDflag() {
        return Dflag;
    }

    public void setDflag(boolean dflag) {
        Dflag = dflag;
    }

//    public long getId() {
//        return roleid;
//    }
//
//    public void setId(long id) {
//        this.roleid = id;
//    }

    public String getRole_name() {
        return rolename;
    }

    public void setRole_name(String role_name) {
        this.rolename = role_name;
    }

}

