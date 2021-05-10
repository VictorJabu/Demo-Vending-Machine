package com.bondo.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String picDest;
    private Long numberOfItemsRemaining;
    private Long price;

    public Product(String name, String picDest, Long numberOfItemsRemaining, Long price) {
        this.name = name;
        this.price = price;
        this.picDest = picDest;
        this.numberOfItemsRemaining = numberOfItemsRemaining;

    }

    public Product() {

    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPicDest() {
        return picDest;
    }

    public void setPicDest(String picDest) {
        this.picDest = picDest;
    }

    public Long getId() {
        return id;
    }

    public Long getNumberOfItemsRemaining() {
        return numberOfItemsRemaining;
    }

    public void setNumberOfItemsRemaining(Long numberOfItemsRemaining) {
        this.numberOfItemsRemaining = numberOfItemsRemaining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
