package com.booking.project.payload.request;

import com.booking.project.models.Hotel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

public class AddReservationRequest {

    private String id;

    private String destination;
    private Date checkin;
    private Date checkout;
    private String nbrAdult;
    private String nbrChildren;


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
