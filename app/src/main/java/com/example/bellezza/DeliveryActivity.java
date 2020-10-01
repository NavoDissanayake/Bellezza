package com.example.bellezza;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;
public class DeliveryActivity extends AppCompatActivity {



    EditText name2, phone2, addr2, city2;
    Button addbtn;
    Delivery deliver;
    DatabaseReference DeliveryRef;
   // String saveCurrentdate,saveCurrentTime;
   // String DeliveryRandomKey;

    //String DeliveryRandomKey, downloadImageUrl;
    ProgressDialog loadingBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        //edit text
        name2 = findViewById(R.id.name1);
        phone2 = findViewById(R.id.phone);
        addr2 = findViewById(R.id.address);
        city2 = findViewById(R.id.city);
        loadingBar = new ProgressDialog(this);

        //button
        addbtn= findViewById(R.id.button2);


        //new deliver object
        deliver = new Delivery();


        //action bar
        setTitle("Delivery Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //insert button
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery");



                try {

                    if (TextUtils.isEmpty(name2.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter your name...", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addr2.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter your address...", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(city2.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter your city...", Toast.LENGTH_SHORT).show();
                    else {




                        //  StoreDeliveryInformation();

                        deliver.setName(name2.getText().toString().trim());
                        deliver.setPhone(Integer.parseInt(phone2.getText().toString().trim()));
                        deliver.setAddress(addr2.getText().toString().trim());
                        deliver.setCity(city2.getText().toString().trim());
                       // deliver.setDate(saveCurrentdate);
                       // deliver.setTime(saveCurrentTime);

                        //DeliveryRef.push().setValue(deliver);
                        DeliveryRef.child("delivery1").setValue(deliver);
                        //DeliveryRef.setValue(deliver);

                        Toast.makeText(getApplicationContext(), "successfully inserted...", Toast.LENGTH_SHORT).show();
                        clearControls();

                        OpenUi();


                    }

                } catch (NumberFormatException e) {

                    Toast.makeText(getApplicationContext(), "invalid contact number....", Toast.LENGTH_SHORT).show();

                }




            }
        });
    }



    //clear inputs
    private void clearControls() {

        name2.setText("");
        phone2.setText("");
        addr2.setText("");
        city2.setText("");

    }




    //open next page
    private void OpenUi() {


        Intent intent = new Intent(this, ConfirmDetailsActivity.class);
        startActivity(intent);


        StoreDeliveryInformation();



    }



    //loading bar
    private void StoreDeliveryInformation(){

        //loadingBar.setIcon(R.drawable.plus);
        loadingBar.setTitle("Bellezza");
        loadingBar.setMessage("Please Wait......");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();




    }


}