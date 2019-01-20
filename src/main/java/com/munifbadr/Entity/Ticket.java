package com.munifbadr.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @Column(name = "TICKETID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketid;

    @Column (name = "DFLAG")
    @GeneratedValue(generator = "false")
    private boolean dflag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERS",referencedColumnName = "UserID")
    private Users userss;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "XEVENT",referencedColumnName = "ID")
    private Event event;

    private boolean attend;

    private String eventname;

    private Time eventtime;

    private Date date;


    private boolean rated;

      private int review;

    private String comment;

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDflag() {
        return dflag;
    }

    public void setDflag(boolean dflag) {
        this.dflag = dflag;
    }

    public Users getUserss() {
        return userss;
    }

    public void setUserss(Users userss) {
        this.userss = userss;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Time getEventtime() {
        return eventtime;
    }

    public void setEventtime(Time eventtime) {
        this.eventtime = eventtime;
    }

    //    public long getIduser() {
//        return iduser;
//    }
//
//    public void setIduser(long iduser) {
//        this.iduser = iduser;
//    }
//
//    public long getIdevent() {
//        return idevent;
//    }
//
//    public void setIdevent(long idevent) {
//        this.idevent = idevent;
//    }
}

