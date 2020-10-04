package com.example.bellezza;

public class Customer {

    String FirstName;
    String LastName;
    String NIC;
    String Address;
    String PhoneNumber;
    String Password;
    String ConfirmPassword;


    public Customer() {


    }


    public Customer(String FirstName, String LastName, String NIC, String Address, String PhoneNumber, String Password, String ConfirmPassword) {

        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.NIC = NIC;
        this.PhoneNumber = PhoneNumber;
        this.Password = Password;
        this.ConfirmPassword = ConfirmPassword;

    }

    public Customer(String theFirstName, String theLastName, String theAddress, String theNIC, String thePhoneNumber) {

    }

    public String getFirstName() {
        return FirstName;
    }


    public void setFirstName(String firstName) {
        FirstName = firstName;


    }


    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }


    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


}







