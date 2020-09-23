package com.example.onlinedeliveryapp;

public class Delivery {


    private String name;
    private Integer phone;
    private String address;
    private String city;

    public Delivery() {

    }

    public Delivery(String name_2, Integer phone_2, String addr_2, String city_2) {


        this.name=name_2;
        this.phone = phone_2;
        this.address= addr_2;
        this.city=city_2;

    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //phone number
    public Integer getPhone() {
        return phone;
    }


    public void setPhone(Integer phone) {
        this.phone = phone;
    }




    //address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    //city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
