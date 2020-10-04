package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.text.TextUtils;

import com.example.bellezza.Customer;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCustomer extends AppCompatActivity {

    EditText FirstName1, LastName1, Address1, NIC1, PhoneNumber1, Password1, ConfirmPassword1;
    Button RegistrationBtn1;
    DatabaseReference databaseCustomers;
    FirebaseDatabase database;
    Customer customer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        database = FirebaseDatabase.getInstance();
        databaseCustomers = database.getReference().child("Customer");

        FirstName1 = findViewById(R.id.editTextTextFirstName);
        LastName1 = findViewById(R.id.editTextTextLastName);
        Address1 = findViewById(R.id.editTextTextCustomerAddress);
        NIC1 = findViewById(R.id.editTextTextNIC);
        PhoneNumber1 = findViewById(R.id.editTextTextPhoneNumber);
        Password1 = findViewById(R.id.editTextTextPassword);
        ConfirmPassword1 = findViewById(R.id.editTextTextConfirmPassword);


        RegistrationBtn1 = findViewById(R.id.RegistrationBtn);

        RegistrationBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
            }
        });

    }


    //method
    private void addCustomer() {


        String FirstName = FirstName1.getText().toString();
        String LastName = LastName1.getText().toString();
        String NIC = NIC1.getText().toString();
        String Address = Address1.getText().toString();
        String PhoneNumber = PhoneNumber1.getText().toString();
        String Password = Password1.getText().toString();
        String Confirm_Password = ConfirmPassword1.getText().toString();


        if (!TextUtils.isEmpty(FirstName) && !TextUtils.isEmpty(LastName) && !TextUtils.isEmpty(Address) && !TextUtils.isEmpty(PhoneNumber) && !TextUtils.isEmpty(NIC) && !TextUtils.isEmpty(Password) && !TextUtils.isEmpty(Confirm_Password)) {
            Customer customer = new Customer(FirstName, LastName, NIC, Address, PhoneNumber, Password, Confirm_Password);
            databaseCustomers.child("996450325V").setValue(customer, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    Toast.makeText(getApplicationContext(), "User created!",  Toast.LENGTH_SHORT);
                    viewPortal();
                }
            });
        } else {
            Toast.makeText(this, "Please all the fields...!", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewPortal() {

        Intent i = new Intent(AddCustomer.this, UserPortal.class);

        startActivity(i);


    }


}

