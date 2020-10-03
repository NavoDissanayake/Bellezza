package com.example.bellezza;

public class Delivery {


    private String name;
    private String phone;
    private String address;
    private String city;
    private String date;
    private String time;
    private String total;


    public Delivery() {

    }

    public Delivery(String name ,String phone , String address , String city,String date , String time ,String total) {
        this.name  = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.date = date ;
        this.time = time;
        this.total = total;

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


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
