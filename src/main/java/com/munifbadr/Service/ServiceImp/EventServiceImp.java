package com.munifbadr.Service.ServiceImp;

import com.munifbadr.Dtos.EventDto;
import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Ticket;
import com.munifbadr.Entity.Users;
import com.munifbadr.mapping.ObjectMapperUtils;
import com.munifbadr.Repositories.EventRepository;
import com.munifbadr.Repositories.TicketRepository;
import com.munifbadr.Repositories.UsersRepository;
import com.munifbadr.Service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MailSenderm mailSender;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public ResponseEntity Create(EventDto eventDto, long organizerid){
        Event event=modelMapper.map(eventDto,Event.class);
        event.setUsers(usersRepository.findById(organizerid).get());
        eventRepository.save(event);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity Update(EventDto events,Long id) {
        Event event=modelMapper.map(events,Event.class);
        List<Ticket> tickets=  new ArrayList<>();
        Event event1=eventRepository.findById(id).get();
        event.setUsers(event1.getUsers());
        event.setEventid(id);
//        if (eventRepository.findById(id).isPresent()) {
//            tickets = ticketRepository.findAllByEventAndDflagIsFalse(event);
//            event.setEventid(id);
            eventRepository.save(event);
//            for (Ticket ticket : tickets) {
//                mailSender.sendSimpleMessage(ticket.getUserss().getEmail(), "Event Update", "event" + event.getName() +
//                        "has been updated please check the website");
            return  ResponseEntity.ok().build();
        }
//return ResponseEntity.notFound().build();
//    }

    @Override
    public ResponseEntity Delete(Long id) {
        Event event = eventRepository.findById(id).get();
        if (eventRepository.findById(id).isPresent()) {
            event.setDflag(true);
            eventRepository.save(event);

            List<Ticket> tickets=  ticketRepository.findAllByEventAndDflagIsFalse(event);
            for(Ticket ticket: tickets) {
                mailSender.sendSimpleMessage(ticket.getUserss().getEmail(), "Event Update", "event" + event.getEventname() +
                        "has been deleted sorry for the inconvenience ");
                ticket.setDflag(true);
            }
               return ResponseEntity.ok().build();


        } else return ResponseEntity.notFound().build();
    }

    @Override
    public EventDto FindById(Long id) {
        if(eventRepository.findById(id).isPresent()) {
            Event event = eventRepository.findById(id).get();
            EventDto eventDto = modelMapper.map(event, EventDto.class);
            return eventDto;
        }
            return null;
        }


    @Override
    public List<EventDto> findcity(String city) {
        Date date= Date.valueOf(LocalDate.now());
        List<Event> events= eventRepository.findAllByCityAndDatedayIsAfterAndApprovedIsTrueAndDflagIsFalse(city,date);
        List<EventDto> eventDtos=ObjectMapperUtils.mapAll(events,EventDto.class);
        return eventDtos;
    }

//    @Override
//    public List<Event> findByCity(String city) {
//        Date date = Date.valueOf(LocalDate.now());
//       return eventRepository.AllCity(city, date);
//    }



    @Override
    public List<Event> FindAllevent() {
        Date date= Date.valueOf(LocalDate.now());
        List<Event> events=eventRepository.findAll();
        //List<EventDto> eventdtos=  ObjectMapperUtils.mapAll(events,EventDto.class);

        return events;

//        LocalDate now = LocalDate.now();
//        List<Event> Result = new ArrayList<>();
//        for (Event result : eventRepository.findAll()) {
//            if (now.minusDays(1).isBefore(result.getDateday().toLocalDate()) && result.isApproved())
//                Result.add(result);
//
//        }
//        return Result;
    }


    public List<Event> NotApproved() {
        Date date= Date.valueOf(LocalDate.now());
       return eventRepository.findAllByApprovedIsFalseAndDflagIsFalseAndDatedayAfter(date);

    }

    @Override
    public List<Event> Approved() {
        Date date=Date.valueOf(LocalDate.now().minusDays(1));
       List <Event> events= eventRepository.findAllByApprovedIsTrueAndDflagIsFalseAndDatedayAfter(date);
      return events;
    }

//    @Override
//    public List<Event> FindByCity(String City) {
//        LocalDate now = LocalDate.now();
//        List<Event> Result = new ArrayList<>();
//        for (Event result : eventRepository.findAll()) {
//            if (now.minusDays(1).isBefore(result.getDateday().toLocalDate()) &&
//                    Approved(result.getEventid())&&
//                    result.getCity().equalsIgnoreCase(City))
//                Result.add(result);
//
//        }
//        return Result;
//    }

    @Override
    public List<EventDto> FindByDate(Date Dated) {

        List<Event> events= eventRepository.findAllByApprovedIsTrueAndDflagIsFalseAndDatedayIn(Dated) ;
        List<EventDto> eventDtos=ObjectMapperUtils.mapAll(events,EventDto.class);
        return eventDtos;
    }

    @Override
    public List<EventDto> FindByCd(String city, Date dated) {
        List<Event> events= eventRepository.findAllByApprovedIsTrueAndDflagIsFalseAndCityAndDatedayIn(city,dated);
        List<EventDto> eventDtos=ObjectMapperUtils.mapAll(events,EventDto.class);
        return eventDtos;
    }

    @Override
    public void Approve(Long id) {
        Event event = eventRepository.findById(id).get();
        event.setApproved(true);
        eventRepository.save(event);
    }

    @Override
    public void disApprove(Long id) {
        Event event = eventRepository.findById(id).get();
        event.setApproved(false);
        eventRepository.save(event);
    }

//    public int rateorg(Long id){
//        Users users= usersRepository.findById(id).get();
//        List<Event> events=eventRepository.findAllByUsersAndDflagIsFalse(users);
//        int i=0;
//        int rate=0;
//        for (Event event:events){
//           rate=+ event.getReview();
//           ++i;
//        }
//        return rate/i;
//
//    }

    @Override
    public List<Event> myevents(Long id) {
        return eventRepository.findAllByUsersAndDflagIsFalse(usersRepository.findById(id).get());    }


}
