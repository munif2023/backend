package com.munifbadr.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "rate")
public class Rate {

   @Id
    @Column()
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long rateid;

    @Column(columnDefinition = "int default 0")
    @Min(0)
    @Max(5)
    private int review;

    @OneToOne
    @JoinColumn(name = "TICKETID")
    private Ticket ticket;

    @Column(columnDefinition = "int default 0")
    private boolean dflage;

    @Column
    private String coumnt;



    public String getCoumnt() {
        return coumnt;
    }

    public void setCoumnt(String coumnt) {
        this.coumnt = coumnt;
    }

    public Long getRateid() {
        return rateid;
    }

    public void setRateid(Long rateid) {
        this.rateid = rateid;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isDflage() {
        return dflage;
    }

    public void setDflage(boolean dflage) {
        this.dflage = dflage;
    }

}
