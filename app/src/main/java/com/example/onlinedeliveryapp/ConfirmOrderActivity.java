package com.example.onlinedeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConfirmOrderActivity extends AppCompatActivity {
    Button button;
    TextView confirmName,confirmPhone,confirmAddress,confirmCity;
    Delivery deliver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);


        confirmName = findViewById(R.id.name2);
        confirmPhone=findViewById(R.id.phone2);
        confirmAddress= findViewById(R.id.address2);
        confirmCity=findViewById(R.id.city2);


        deliver = new Delivery();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");


        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    confirmName.setText(dataSnapshot.child("name").getValue().toString());
                    confirmPhone.setText(dataSnapshot.child("phone").getValue().toString());
                    confirmAddress.setText(dataSnapshot.child("address").getValue().toString());
                    confirmCity.setText(dataSnapshot.child("city").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //action bar
        setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //confirm button
        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }





        });


        }

    //alert
    private void openDialog() {
        ConfirmDialog confirmdialog = new ConfirmDialog();
        confirmdialog.show(getSupportFragmentManager(),"confirm dialog");

    }






}
