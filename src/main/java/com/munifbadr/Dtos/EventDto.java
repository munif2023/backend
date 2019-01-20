package com.munifbadr.Dtos;


import com.munifbadr.Entity.Comment;
import com.munifbadr.Entity.Users;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
@Component
public class EventDto {
    private long eventid;
    private String city;
    private Date dateday;
    private Time Timev;
    private Long Seatnum;
    private long count;
    private String name;
    private int review;
    private String eventname;
    private boolean approved;
    private Users users;
    private List<Comment> comment;

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
}
