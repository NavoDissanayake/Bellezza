package com.example.bellezza;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import  android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bellezza.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.Objects;


public class UpdateAccount extends AppCompatActivity {

    Button deleteButton, updateButton;
    EditText FirstName1, LastName1, Address1, PhoneNumber1, NIC1;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseCustomer = database.getReference("customer");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);

        //Edit texts
        FirstName1   = findViewById(R.id.editTextTextFirstName);
        LastName1    = findViewById(R.id.editTextTextLastName);
        Address1     = findViewById(R.id.editTextTextCustomerAddress);
        PhoneNumber1 = findViewById(R.id.editTextTextNIC);
        NIC1         = findViewById(R.id.editTextTextPhoneNumber);


        //buttons

        deleteButton = findViewById(R.id.DeleteCustomerAccountButton);
        updateButton = findViewById(R.id.UpdateCustomerAccountButton);

        //load logged rider details
        //getValues();





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


        //click update button
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateCustomerDetails();
            }



        });

        //click delete button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteCustomerDetails();
            }

        });

    }

    //delete customer details method

    public void deleteCustomerDetails() {

        String customerNicForDelete = NIC1.getText().toString();

        if (!TextUtils.isEmpty(customerNicForDelete)) {

            Query deleteQuery = databaseCustomer.orderByChild("NIC").equalTo(customerNicForDelete);

            deleteQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                        appleSnapshot.getRef().removeValue();
                        Toast toast = Toast.makeText(getApplicationContext(), "Account is deleted", Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(new Intent(getApplicationContext(), Login.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        } else {

            Toast toast = Toast.makeText(this, "Please fill all the fields..!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    //update customer details method

    public void updateCustomerDetails(){


        String FirstName          =  FirstName1.getText().toString();
        String LastName           =  LastName1.getText().toString();
        String Address            =  Address1.getText().toString();
        String NIC                =  NIC1.getText().toString();
        String PhoneNumber        =  PhoneNumber1.getText().toString();



        if(!TextUtils.isEmpty(FirstName) && !TextUtils.isEmpty(LastName) && !TextUtils.isEmpty(Address) && !TextUtils.isEmpty(NIC) && !TextUtils.isEmpty(PhoneNumber))
        {

            Customer customer = new Customer (FirstName, LastName, Address, NIC, PhoneNumber);
            databaseCustomer.child(NIC).setValue(customer);

            Toast toast = Toast.makeText(this, "Updating", Toast.LENGTH_SHORT);
            toast.show();


        }else{

            Toast toast = Toast.makeText(this, "Please fill all the fields..!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }



    public void getValues() {

        GlobalClass global= ( (GlobalClass) getApplicationContext() );
        Query deleteQuery = databaseCustomer.orderByChild("NIC").equalTo(global.getLoggedCustomerNIC());

        deleteQuery.addListenerForSingleValueEvent(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot riderSnapshot : dataSnapshot.getChildren()) {

                    String FirstName = Objects.requireNonNull(riderSnapshot.child("firstName").getValue()).toString();
                    String LastName = Objects.requireNonNull(riderSnapshot.child("lastName").getValue()).toString();
                    String Address = Objects.requireNonNull(riderSnapshot.child("address").getValue()).toString();
                    String NIC = Objects.requireNonNull(riderSnapshot.child("nic").getValue()).toString();
                    String PhoneNumber = Objects.requireNonNull(riderSnapshot.child("phoneNumber").getValue()).toString();

                    FirstName1.setText(FirstName);
                    LastName1.setText(LastName);
                    Address1.setText(Address);
                    PhoneNumber1.setText(PhoneNumber);
                    NIC1.setText(NIC);

                }
            }
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


    }


}







