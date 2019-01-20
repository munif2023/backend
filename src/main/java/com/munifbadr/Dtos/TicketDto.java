package com.munifbadr.Dtos;

import java.sql.Date;

public class TicketDto {
    private UsersDto userss;
    private EventDto event;
    private Date date;
    private long ticketid;

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public UsersDto getUserss() {
        return userss;
    }

    public void setUserss(UsersDto userss) {
        this.userss = userss;
    }

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(EventDto event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
