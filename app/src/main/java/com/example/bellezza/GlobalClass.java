
package com.example.bellezza;

import android.app.Application;

public class GlobalClass extends Application {
    private String loggedCustomerNIC;
    private  String pwd;


    public GlobalClass(){


    }

    public void setLoggedCustomerNIC(String loggedCustomerNIC , String pwd){

        this.loggedCustomerNIC = loggedCustomerNIC;
        this.pwd = pwd;


    }


    public void setGetLoggedCustomerNIC(String getLoggedCustomerNIC) {
        this.loggedCustomerNIC = getLoggedCustomerNIC;
    }

    public void setLoggedCustomerNIC(String enteredUsername) {
    }

    public String getLoggedCustomerNIC() {
        return  loggedCustomerNIC;
    }

}
