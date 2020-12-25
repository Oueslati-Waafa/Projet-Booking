package com.booking.project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;

    private String destination;
    private Date checkin;
    private Date checkout;
    private String nbrAdult;
    private String nbrChildren;




    public Reservation() {
    }

    public Reservation(String destination, Date checkin, Date checkout, String nbrAdult, String nbrChildren) {

        this.destination = destination;
        this.checkin = checkin;
        this.checkout = checkout;
        this.nbrAdult = nbrAdult;
        this.nbrChildren = nbrChildren;

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getNbrAdult() {
        return nbrAdult;
    }

    public void setNbrAdult(String nbrAdult) {
        this.nbrAdult = nbrAdult;
    }

    public String getNbrChildren() {
        return nbrChildren;
    }

    public void setNbrChildren(String nbrChildren) {
        this.nbrChildren = nbrChildren;
    }


}
