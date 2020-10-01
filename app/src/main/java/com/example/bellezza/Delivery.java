package com.example.bellezza;

public class Delivery {


    private String name;
    private Integer phone;
    private String address;
    private String city;


    public Delivery() {

    }

    public Delivery(String name, Integer phone, String addr, String city) {


        this.name=name;
        this.phone = phone;
        this.address= addr;
        this.city=city;


    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //phone number
    //public static Integer getPhone() {
     //   return phone;
    //}


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
