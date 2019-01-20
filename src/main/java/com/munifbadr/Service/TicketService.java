package com.munifbadr.Service;

import com.munifbadr.Dtos.TicketDto;
import com.munifbadr.Entity.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {
    public void Create(TicketDto ticket);

    public ResponseEntity Update(TicketDto ticket, Long id);

    public ResponseEntity Delete(Long id);

    public ResponseEntity<Object> FindById(Long id);

    public List<TicketDto> FindAll();

    public List<TicketDto> findAllmytickets(Long id);

    List<Ticket> getMyTicket(long id);

    List<Ticket> getMyAttendedTicket(long id);

    List<Ticket> getEventsTicket(long id);

    void attend(Long id);


}
