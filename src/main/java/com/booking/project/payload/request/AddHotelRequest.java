package com.booking.project.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddHotelRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    private Double price;

    @NotBlank
    @Size(min = 6, max = 200)
    private String address;

    private Set<String> reviewList;


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

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getReviewList() {
        return this.reviewList;
    }

    public void setReviewList(Set<String> reviewList) {
        this.reviewList = reviewList;
    }
}
