/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.math.BigDecimal;

/**
 *
 * @author Dongyu Zhao 27356094
 * 
 */
public class Property {
    //TODO Exercise 1A Step 1 Please refer tutorial exercise. 
    //attributes
    private int id;
    private String address;
    private int numberOfBedrooms;
    private int size;
    private BigDecimal price;

    //default constructor
    public Property() {
    }

    //non-default constructor
    public Property(int id, String address, int numberOfBedrooms, int size, BigDecimal price) {
        this.id = id;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.size = size;
        this.price = price;
    }

    //get id
    public int getId() {
        return id;
    }

    //set id
    public void setId(int id) {
        this.id = id;
    }

    //get address
    public String getAddress() {
        return address;
    }

    //set address
    public void setAddress(String address) {
        this.address = address;
    }

    //get size
    public int getSize() {
        return size;
    }

    //set size
    public void setSize(int size) {
        this.size = size;
    }
    
    //get number of bedrooms
    public int getNumberofBedrooms() {
        return numberOfBedrooms;
    }
    
    //set number of bedrooms
    public void setNumberOfBedrooms(int number) {
        this.numberOfBedrooms = number;
    }

    //get price
    public BigDecimal getPrice() {
        return price;
    }

    //set price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //to string method
    @Override
    public String toString() {
        return id + " " + address + " " + numberOfBedrooms + " bedroom(s) " + size + "sqm $" + price;
    }
    
}
