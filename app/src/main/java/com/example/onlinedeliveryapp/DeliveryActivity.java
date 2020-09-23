package com.example.onlinedeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.HashMap;





public class DeliveryActivity extends AppCompatActivity {


    private Button button;
    private EditText name2, phone2, addr2, city2;
    private String saveCurrentdate, saveCurrentTime;
    private Delivery deliver;
    private DatabaseReference DeliveryRef;
    private DataSnapshot dataSnapshot;


     //String DeliveryRandomKey, downloadImageUrl;
    //private ProgressDialog loadingBar;


    //clear texts
    private void clearControls() {

        name2.setText("");
        phone2.setText("");
        addr2.setText("");
        city2.setText("");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);


        button = findViewById(R.id.button2);
        name2 = findViewById(R.id.name1);
        phone2 = findViewById(R.id.phone);
        addr2 = findViewById(R.id.address);
        city2 = findViewById(R.id.city);
        //loadingBar = new ProgressDialog(this);

        deliver = new Delivery();


        //action bar
        setTitle("Delivery Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //next button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeliveryActivity.this, ConfirmDetailsActivity.class);
                startActivity(i);

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ValidateDeliveryData();


            }
        });
    }









        private void ValidateDeliveryData(){


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


                    //DeliveryRef.push().setValue(deliver);
                    DeliveryRef.child("delivery1").setValue(deliver);


                    Toast.makeText(getApplicationContext(), "successfully inserted...", Toast.LENGTH_SHORT).show();
                    clearControls();




                    Intent intent1 = new Intent(DeliveryActivity.this, ConfirmDetailsActivity.class);
                    startActivity(intent1);


                    //read data
                    /* DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");

                    DeliveryRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(dataSnapshot.hasChildren()){


                                String name_2   =dataSnapshot.child("name").getValue().toString();
                                String phone_2  =dataSnapshot.child("phone").getValue().toString();
                                String addr_2   =dataSnapshot.child("address").getValue().toString();
                                String city_2   =dataSnapshot.child("city").getValue().toString();



                                Intent intent3 = new Intent(getApplicationContext(), ConfirmDetailsActivity.class);

                                intent3.putExtra("name", name_2);
                                intent3.putExtra("phone", phone_2);
                                intent3.putExtra("address", addr_2);
                                intent3.putExtra("city", city_2);

                                startActivity(intent3);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


*/


                }

            } catch (NumberFormatException e) {

                Toast.makeText(getApplicationContext(), "invalid contact number....", Toast.LENGTH_SHORT).show();

            }


        }



    }



  /*  private void StoreDeliveryInformation() {

        //loadingBar.setIcon(R.drawable.plus);
        loadingBar.setTitle("Bellezza");
        loadingBar.setMessage("Please Wait......");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentdate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        DeliveryRandomKey = saveCurrentdate + saveCurrentTime;


    }
*/









