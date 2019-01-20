package com.munifbadr.Repositories;

import com.munifbadr.Entity.Event;
import com.munifbadr.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import java.util.List;
@Repository
public interface EventRepository  extends JpaRepository<Event,Long> {
    Event  findByDateday (String dateday);



public List<Event> findAllByCityAndDatedayIsAfterAndApprovedIsTrueAndDflagIsFalse(String City,Date dateday);

public List<Event> findAllByDatedayIsAfterAndApprovedIsTrueAndDflagIsFalse(Date date);

    public List<Event> findAllByApprovedIsTrueAndDflagIsFalseAndDatedayIn(Date date);

    public List<Event> findAllByApprovedIsTrueAndDflagIsFalseAndCityAndDatedayIn(String city,Date date);

    public List<Event> findAllByApprovedIsFalseAndDflagIsFalseAndDatedayAfter(Date date);
    List<Event>    findAllByUsersAndDflagIsFalse(Users users);

    public List<Event> findAllByApprovedIsTrueAndDflagIsFalseAndDatedayAfter(Date date);





}
