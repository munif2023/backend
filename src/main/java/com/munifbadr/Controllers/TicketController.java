package com.munifbadr.Controllers;

import com.munifbadr.Dtos.TicketDto;
import com.munifbadr.Entity.Ticket;
import com.munifbadr.Service.ServiceImp.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketServiceImp ticketServiceImp;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    @PreAuthorize( "hasRole('ROLE_ADMIN')" )
    List<TicketDto> findAll() {
     return ticketServiceImp.FindAll();

    }
//    @RequestMapping(method = RequestMethod.POST,value =  "/Tickets/Save")
//    private void save(Ticket ticket){
//        ticketServiceImp.Create(ticket);
//    }

    @GetMapping("/ticket/delete/{id}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER')" )
         ResponseEntity delete(@Valid@PathVariable Long id){
        return ticketServiceImp.Delete(id);
        }

        @GetMapping("/ticket/myticket/{id}")
        @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER')" )
         List<TicketDto> myticket(@Valid @PathVariable Long id){
        return ticketServiceImp.findAllmytickets(id);
        }

        @PutMapping("/ticket/update")
        @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_ORGANIZER')" )
         ResponseEntity update(@Valid @RequestBody TicketDto ticketDto,@Valid Long id){
        return ticketServiceImp.Update(ticketDto,id);
        }



    @GetMapping("/book/{userid}/{eventid}")
    @PreAuthorize( "hasAnyRole('ROLE_ADMIN','ROLE_USER')" )
     ResponseEntity booking( @PathVariable @Valid Long userid ,@PathVariable @Valid Long eventid){
        return ticketServiceImp.Book(userid,eventid);

    }

    @GetMapping("/mytickets/{userid}")
    @PreAuthorize( "hasRole('ROLE_USER')" )
    List<Ticket> getMyTicket( @PathVariable @Valid Long userid){
        return ticketServiceImp.getMyTicket(userid);
    }

    @GetMapping("/mytickets/attended/{userid}")
    @PreAuthorize( "hasRole('ROLE_USER')" )
    List<Ticket> getMyAttendedTicket( @PathVariable @Valid Long userid){
        return ticketServiceImp.getMyAttendedTicket(userid);
    }

    @GetMapping("/events/tickets/{eventid}")
    @PreAuthorize( "hasRole('ROLE_ORGANIZER')" )
    List<Ticket> getEventsTicket( @PathVariable @Valid Long eventid){
        return ticketServiceImp.getEventsTicket(eventid);
    }

    @PutMapping("/ticket/conform/{ticketid}")
    @PreAuthorize( "hasRole('ROLE_ADMIN')" )
     public void attend(@PathVariable Long ticketid){
     ticketServiceImp.attend(ticketid);
    }
}