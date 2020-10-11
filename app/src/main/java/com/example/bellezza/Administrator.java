package com.example.bellezza;

public class Administrator {

    String AdminId;
    String AdminName;
    String AdminEmail;
    String phone;
    String password;
    String NIC;

    public Administrator(String adminId, String adminName, String adminEmail, String phone, String password) {
        AdminId = adminId;
        AdminName = adminName;
        AdminEmail = adminEmail;
        this.phone = phone;
        this.password = password;
        this.NIC = NIC;
    }

    public String getAdminId() {
        return AdminId;
    }

    public String getNIC() {
        return NIC;
    }


    public String getAdminName() {
        return AdminName;
    }


    public String getAdminEmail() {
        return AdminEmail;
    }


    public String getPhone() {
        return phone;
    }



    public String getPassword() {
        return password;
    }

}
