package com.munifbadr.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public  class  Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String comment;
    @Column
    private LocalDateTime localDateTime;

    @Column(name = "DFLAG", nullable = false, columnDefinition = "int default 0")
    private boolean dflag;

    @ManyToOne
    @JoinColumn(name = "XEVENT",referencedColumnName = "ID")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn (name = "USERS",referencedColumnName = "UserID")
    private Users users;

    public boolean isDflag() {
        return dflag;
    }

    public void setDflag(boolean dflag) {
        this.dflag = dflag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
