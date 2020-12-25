package com.booking.project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;

    @DBRef(lazy = true)
    private List<Reservation> reservations_ids;


    @NotBlank
    @Size(max = 200)
    private String name;
    private Double price;
    private String address;
    private Set<Review> reviewList;

    public Hotel() {

    }



    public Hotel(String name, Double price, String address) {
        this.name = name;
        this.price = price;
        this.address = address;

    }

    public List<Reservation> getReservations_ids() {
        return reservations_ids;
    }

    public void setReservations_ids(List<Reservation> reservations_ids) {
        this.reservations_ids = reservations_ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(Set<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
