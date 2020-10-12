package com.example.bellezza;

public class Administrator {

    String AdminId;
    String AdminName;
    String AdminEmail;
    String phone;
    String password;
    String ConfirmPassword;
    String NIC;



    public Administrator(String adminId, String adminName, String adminEmail, String phone, String password, String confirmPassword) {
        AdminId = adminId;
        AdminName = adminName;
        AdminEmail = adminEmail;
        this.phone = phone;
        this.password = password;
        this.NIC = NIC;
        this.ConfirmPassword = confirmPassword;
    }

    public Administrator(String id, String name, String email, String phone, String pwd, String nic, String cpwd) {
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
    public String getConfirmPassword() {
        return ConfirmPassword;
    }
}
