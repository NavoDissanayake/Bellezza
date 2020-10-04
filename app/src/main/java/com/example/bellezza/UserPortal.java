package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


//import com.example.bellezza.DeleteAccount;
//import com.example.bellezza.Logout;
//import com.example.bellezza.UpdateAccount;



public class UserPortal extends AppCompatActivity {

    Button btn1 , btn2 , btn3 , btn4;
    TextView FirstName1 , LastName1 , Address1 , PhoneNumber1 , NIC1 ;
    Customer customer;
    DatabaseReference databaseCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_portal);



        FirstName1   = findViewById(R.id.editTextTextFirstName);
        LastName1    = findViewById(R.id.editTextTextLastName);
        Address1     = findViewById(R.id.editTextTextCustomerAddress);
        PhoneNumber1 = findViewById(R.id.editTextTextPhoneNumber);

        NIC1         = findViewById(R.id.editTextTextNIC);

        customer = new Customer();

       // btn1 = findViewById(R.id.CustomerAccountButton);
       btn2 = findViewById(R.id.UpdateCustomerAccountButton);
       btn3 = findViewById(R.id.DeleteCustomerAccountButton);
       // btn4 = findViewById(R.id.CustomerLogoutButton);




        setTitle("My Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Customer").child("996450325V");


        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {



                    FirstName1.setText(dataSnapshot.child("firstName").getValue().toString());
                    LastName1.setText(dataSnapshot.child("lastName").getValue().toString());
                    Address1.setText(dataSnapshot.child("address").getValue().toString());
                    PhoneNumber1.setText(dataSnapshot.child("phoneNumber").getValue().toString());
                    NIC1.setText(dataSnapshot.child("nic").getValue().toString());




                } else
                    Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getBaseContext(),.class));
            }
        });*/

       btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(UserPortal.this, UpdateAccount.class);

                startActivity(i);
            }

            });


}


    }

