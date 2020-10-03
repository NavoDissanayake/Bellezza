package com.example.bellezza;

public class Delivery {


    private String name;
    private String phone;
    private String address;
    private String city;


    public Delivery() {

    }

    public Delivery(String name ,String phone , String address , String city) {
        this.name  = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
