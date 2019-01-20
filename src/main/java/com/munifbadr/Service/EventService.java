package com.munifbadr.Service;

import com.munifbadr.Dtos.EventDto;
import com.munifbadr.Entity.Event;

import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;


public interface EventService {
    public ResponseEntity Create(EventDto eventDto, long organizerid);

    public ResponseEntity Update(EventDto roles, Long id);

    public ResponseEntity Delete(Long id);

    public EventDto FindById(Long id);

  public List<Event> FindAllevent();

public List<EventDto> findcity(String city);


    public List<Event> NotApproved();
    public List<Event> Approved();

    public List<EventDto> FindByDate(Date Dated);

    public List<EventDto> FindByCd(String City, Date Dated);

    public void Approve(Long id);

    public void disApprove(Long id);


//    int rateorg(Long id);

    List<Event> myevents(Long id);





}
