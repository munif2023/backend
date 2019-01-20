package com.munifbadr.Service.ServiceImp;

import com.munifbadr.Dtos.TicketDto;
import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Ticket;
import com.munifbadr.Entity.Users;
import com.munifbadr.mapping.ObjectMapperUtils;
import com.munifbadr.Repositories.EventRepository;
import com.munifbadr.Repositories.TicketRepository;
import com.munifbadr.Repositories.UsersRepository;
import com.munifbadr.Service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class TicketServiceImp implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MailSenderm mailSenderm;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void Create(TicketDto ticket) {
        Ticket ticket1=modelMapper.map(ticket,Ticket.class);
        ticketRepository.save(ticket1);
    }

    @Override
    public ResponseEntity Update(TicketDto ticket, Long id) {

       // Optional<Ticket> tickets = ticketRepository.findById(id);
        Ticket ticket1=modelMapper.map(ticket,Ticket.class);
        if (ticketRepository.findById(id).isPresent()) {
            ticket1.setTicketid(id);
            ticketRepository.save(ticket1);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity Delete(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticket.get().setDflag(true);
            ticket.get().getEvent().setCount(ticket.get().getEvent().getCount()-1);
            ticketRepository.save(ticket.get());
            mailSenderm.sendSimpleMessage(ticket.get().getUserss().getEmail(),"Event Booking Canleing",
                    "you have scussefull canceled "+ticket.get().getEvent().getEventname()+"booking");
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> FindById(Long id) {
        Optional<Ticket> users = ticketRepository.findById(id);

        if (users.isPresent() && !users.get().isDflag()) {
            return ResponseEntity.accepted().body(users.get());
        }


        return ResponseEntity.notFound().build();
    }

    @Override
    public List<TicketDto> FindAll() {
        List<Ticket> Result = ticketRepository.findAllByDflagIsFalse();
      List<TicketDto> ticketDtos=ObjectMapperUtils.mapAll(Result,TicketDto.class);
        return ticketDtos;
    }

    @Override
    public List<TicketDto> findAllmytickets(Long id) {
        Users users=usersRepository.findById(id).get();
        List<Ticket> tickets= ticketRepository.findAllByUserssAndDflagIsFalse(users);
        List<TicketDto> ticketDtos=ObjectMapperUtils.mapAll(tickets,TicketDto.class);
        return ticketDtos;


    }

    @Override
    public List<Ticket> getMyTicket(long id) {
        Users users = usersRepository.findById(id).get();
        return ticketRepository.findAllByUserssAndDflagIsFalseAndAttendIsFalse(users);
    }

    @Override
    public List<Ticket> getMyAttendedTicket(long id) {
        Users users = usersRepository.findById(id).get();
        return ticketRepository.findAllByUserssAndDflagIsFalseAndAttendIsTrue(users);    }

    @Override
    public List<Ticket> getEventsTicket(long id) {
        Event event = eventRepository.findById(id).get();
        return ticketRepository.findAllByEventAndDflagIsFalse(event);
    }

    @Override
    public void attend(Long id) {
        Ticket ticket=ticketRepository.findById(id).get();
        ticket.setAttend(true);
        ticketRepository.save(ticket);

    }


    public ResponseEntity Book(@Valid Long userid, @Valid Long eventid) {
        Users users=usersRepository.findById(userid).get();
        Event event= eventRepository.findById(eventid).get();
        Date date=Date.valueOf(LocalDate.now().minusDays(1));
        if (ticketRepository.countByUserssAndDflagIsFalseAndDateIn(users,event.getDateday())==1) {
            return ResponseEntity.badRequest().build();
        }
        if (eventRepository.findById(eventid).isPresent() && usersRepository.findById(userid).isPresent()
                && eventRepository.findById(eventid).get().getCount()<eventRepository.findById(eventid).get().getSeatnum()
                && eventRepository.findById(eventid).get().isApproved()
                && !eventRepository.findById(eventid).get().isDflag()&& !usersRepository.findById(userid).get().isD_Flag()
                &&eventRepository.findById(eventid).get().getDateday().after(date)) {
            Ticket ticket = new Ticket();
            ticket.setUserss(usersRepository.findById(userid).get());
            ticket.setEvent(eventRepository.findById(eventid).get());
            ticket.setDate(event.getDateday());
            ticket.setEventname(event.getEventname());
            ticket.setEventtime(event.getTimev());
            eventRepository.findById(eventid).get().setCount(eventRepository.findById(eventid).get().getCount()+1);
            ticketRepository.save(ticket);
            Long counter=eventRepository.findById(eventid).get().getCount();
            counter++;
//            mailSenderm.sendSimpleMessage(ticket.getUserss().getEmail(),"Event Booking","you have scussfule booked "+event.getEventname());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
