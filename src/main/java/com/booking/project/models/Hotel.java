package com.booking.project.models;

import com.booking.project.models.Address;
import com.booking.project.models.Review;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class Hotel {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String name;

    private Double price;
    private Address address;
    private List<Review> reviewList;

    public Hotel() {

    }

    public Hotel(String name, Double price, Address address, List<Review> reviewList) {
        this.name = name;
        this.price = price;
        this.address = address;
        this.reviewList = reviewList;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
