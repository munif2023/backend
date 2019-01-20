package com.munifbadr.Repositories;

import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Ticket;
import com.munifbadr.Entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface TicketRepository extends CrudRepository <Ticket,Long> {

    List<Ticket>findAllByUserssAndDflagIsFalse(Users users);

    List<Ticket>findAllByEventAndDflagIsFalse(Event event);

    List<Ticket> findAllByUserssAndDflagIsFalseAndAttendIsFalse(Users users);

    List<Ticket> findAllByUserssAndDflagIsFalseAndAttendIsTrue(Users users);


    int  countByUserssAndDflagIsFalseAndDateIn(Users users, Date date);
    List<Ticket> findAllByDflagIsFalse();
}
