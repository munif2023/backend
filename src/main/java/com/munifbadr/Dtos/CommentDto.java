package com.munifbadr.Dtos;


import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Users;

import java.time.LocalDateTime;

public class CommentDto {

    private String comment;
    private LocalDateTime localDateTime;
    private Event event;
    private Users users;
    private long id;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
