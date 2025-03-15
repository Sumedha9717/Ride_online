package com.rideCompany.model;

public class Vehicle {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  String  name;
    private  String price;
    private  String status;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private  String destination;

    public Vehicle(String name, String price , String destination) {
        this.name=name;
        this.price=price;
        this.destination=destination;

    }
}
