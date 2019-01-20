package com.munifbadr.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "XEVENT")
public class Event {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventid;

    @Column(name = "CITY",nullable = false)
    @Size(min = 3,max = 40,message = "TooManyCharorTooFewC")
    private String city;

    @Column(name = "DATEDAY",nullable = false)
    private Date dateday;

    @Column(name = "TIMEV")
    private Time Timev;

    @Column(name = "SEATNUM" ,nullable = false)
    @Min(value = 10)
    private Long Seatnum;

    @Column(name = "DFLAG", nullable = false, columnDefinition = "int default 0")
    private boolean dflag;

    @Column(name = "EDITBY")
    @Size(min = 3,max = 40,message = "TooManyCharorTooFewC")
    private String Editby;

    @Column(name = "DATEOFADD")
    private Date Dateofadd;

    @Column (name = "APPROVED",nullable = false, columnDefinition = "int default 0")
    private boolean approved;

    @Column(name = "NUMBERS",nullable = false,columnDefinition = "int default 0")
    private long count;

    @Column
    private String eventname;

//    @Column(columnDefinition = "int default 0")

//    @Max(5)
//    private int review;

    @ManyToOne
    @JoinColumn(name = "users",referencedColumnName = "UserID")
    private Users users;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comment;


    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateday() {
        return dateday;
    }

    public void setDateday(Date dateday) {
        this.dateday = dateday;
    }

    public Time getTimev() {
        return Timev;
    }

    public void setTimev(Time timev) {
        Timev = timev;
    }

    public Long getSeatnum() {
        return Seatnum;
    }

    public void setSeatnum(Long seatnum) {
        Seatnum = seatnum;
    }

    public boolean isDflag() {
        return dflag;
    }

    public void setDflag(boolean dflag) {
        this.dflag = dflag;
    }

    public String getEditby() {
        return Editby;
    }

    public void setEditby(String editby) {
        Editby = editby;
    }

    public Date getDateofadd() {
        return Dateofadd;
    }

    public void setDateofadd(Date dateofadd) {
        Dateofadd = dateofadd;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

//    public int getReview() {
//        return review;
//    }
//
//    public void setReview(int review) {
//        this.review = review;
//    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
