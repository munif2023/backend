package com.munifbadr.Service.ServiceImp;

import com.munifbadr.Entity.Rate;
import com.munifbadr.Entity.Ticket;
import com.munifbadr.Repositories.RateRepository;
import com.munifbadr.Repositories.TicketRepository;
import com.munifbadr.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class RateServiceImp implements RateService {
    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void Create(Long id) {
       Optional<Rate>  rate=Optional.of(new Rate());
        Date date=Date.valueOf(LocalDate.now());
        if (ticketRepository.existsById(id))
       if(date.after(ticketRepository.findById(id).get().getEvent().getDateday())){
            rate.get().setTicket(ticketRepository.findById(id).get());
            rate.get().setCoumnt("hello");
            rate.get().setReview(4);

            rateRepository.save(rate.get());
        }
  }

    @Override
    public void Update(Rate rate, Long id) {

    }

    @Override
    public void Delete(Long id) {

    }
@Override
    public List<Rate> find(){
       return  rateRepository.findAll();
    }

    @Override
    public ResponseEntity<Rate> rate(Rate rate, Long id) {
        if (ticketRepository.findById(id).isPresent()){
            Ticket ticket=ticketRepository.findById(id).get();
            if(ticket.isAttend()){
                ticket.setRated(true);
                ticket.setReview(rate.getReview());
                ticket.setComment(rate.getCoumnt());
                rate.setTicket(ticket);
                rateRepository.save(rate);
                return ResponseEntity.ok(rate);
            }
            else return new ResponseEntity("you must attend ",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("you must book ",HttpStatus.NOT_FOUND);
    }

}
