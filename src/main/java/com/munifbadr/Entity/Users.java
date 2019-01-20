package com.munifbadr.Entity;

import javax.annotation.MatchesPattern;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="USERS")
public class Users {
    @Id
    @Column(name = "UserID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;

    @NotNull
    @Column(name = "First_Name")
    @Size(min=3 , max = 30, message = "too long or too short")
    @Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
    private String firstname;

    @Column(name = "Second_Name")
    private String secondname;

    @NotNull
    @Column(name = "LAST_NAME")
    @Size(min=3 , max = 50, message = "too long or too short")
    @Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
    private String last_name;

    @NotNull
  @Column(name = "EMAIL")
//    @Size(min=3 , max = 120, message = "too long or too short")
   @Pattern(regexp = "^[_A-z0-9]@gmail.com")
   private String email;

    @NotNull
    @Column(unique = true )
  @Size(min=3 , max = 50, message = "too long or too short")
    @Pattern(regexp = "[^\\s]+")
    @Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
    private String username;

    @NotNull
    @Column
    @Pattern(regexp = "[^\\s]+")
    @Size(min=5 ,  message = "password")
    private String password;

    @Column(name = "DFLAG", nullable = false, columnDefinition = "int default 0")
    private boolean d_Flag;

    @Column(name = "DATE_ADD")
    private String date_add;

    @Column(name = "EDIT_BY")
    private String edit_by;

    @ManyToOne
    @JoinColumn(name = "roles",referencedColumnName = "rolename")
    private Roles roles;

    @Column(columnDefinition = "int default 1")
    private Boolean enabled;

    @Column
    private String userphone;


    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastname) {
        this.last_name = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isD_Flag() {
        return d_Flag;
    }

    public void setD_Flag(boolean d_Flag) {
        this.d_Flag = d_Flag;
    }

    public String getDate_add() {
        return date_add;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
    }

    public String getEdit_by() {
        return edit_by;
    }

    public void setEdit_by(String edit_by) {
        this.edit_by = edit_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}