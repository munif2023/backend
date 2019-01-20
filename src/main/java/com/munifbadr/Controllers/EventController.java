package com.munifbadr.Controllers;

import com.munifbadr.Dtos.EventDto;
import com.munifbadr.Entity.Event;
import com.munifbadr.Service.ServiceImp.EventServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EventController {


@Autowired
private EventServiceImp eventService;



//@GetMapping(name = "/events")

@RequestMapping(value = "/events", method = RequestMethod.GET)
@PreAuthorize( "hasAnyRole('ROLE_ADMIN')" )
 List<Event>find(){
    return eventService.FindAllevent();
}

@RequestMapping(method = RequestMethod.POST,value ="/event/add/{organizerid}")
@PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')" )
     void save( @Valid @RequestBody EventDto event, @PathVariable long organizerid){
    eventService.Create(event,organizerid);
}


@RequestMapping( method =RequestMethod.GET ,value ="/events/city/{City}")
@PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
     List<EventDto> findbycity(@Valid @PathVariable String City){
    return eventService.findcity(City);
}

    @RequestMapping( method =RequestMethod.GET ,value ="/events/date/{date}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
     List<EventDto> findbydate(@Valid @PathVariable Date date){
    return eventService.FindByDate(date);
    }

    @RequestMapping( method =RequestMethod.GET ,value ="/events/CD/{city}/{date}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
 List<EventDto> findCD(@Valid @PathVariable String city,@Valid @PathVariable Date date){
    return eventService.FindByCd(city, date);
    }
    @RequestMapping( method =RequestMethod.GET ,value ="/events/notapproved")
     List<Event> notapproved(){
    return eventService.NotApproved();
    }

    @RequestMapping( method =RequestMethod.PUT ,value ="/event/update/{id}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')" )
     void update(@Valid@RequestBody EventDto event,@Valid @PathVariable Long id){
        eventService.Update(event,id);
    }

    @DeleteMapping("/events/{id}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')" )
     void del(@PathVariable Long id){
        eventService.Delete(id);
    }


    @GetMapping("/myevent/{id}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')" )
    public List<Event> myevent(@PathVariable Long id){
    return eventService.myevents(id);
    }

    @GetMapping("/event/{id}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_ORGANIZER')" )
    public ResponseEntity event(@PathVariable Long id){
    return ResponseEntity.ok(eventService.FindById(id)) ;
    }

    @GetMapping("/event/approve/{id}")
    public void Approve(@PathVariable Long id) {
     eventService.Approve(id);
    }

    @GetMapping("/event/disapprove/{id}")
    public void disApprove(@PathVariable Long id) {
        eventService.disApprove(id);
    }


    @GetMapping("/events/approved")
    public List app(){
        return eventService.Approved();
    }


}
