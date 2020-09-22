package com.example.onlinedeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;




public class DeliveryActivity extends AppCompatActivity {
    private Button button;
    private EditText name2,phone2,addr2,city2;
    private String Cname , PhoneNo,Address, City,saveCurrentdate, saveCurrentTime;
    Delivery deliver;
    private DatabaseReference DeliveryRef;

    private String DeliveryRandomKey, downloadImageUrl;


    private ProgressDialog loadingBar;

    private  void clearControls(){

        name2.setText("");
        phone2.setText("");
        addr2.setText("");
        city2.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery");

        button =(Button) findViewById(R.id.button2);
        name2 = (EditText) findViewById(R.id.name1);
        phone2 = (EditText) findViewById(R.id.phone);
        addr2 = (EditText) findViewById(R.id.address);
        city2 = (EditText) findViewById(R.id.city);
        loadingBar = new ProgressDialog(this);

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
            public void onClick(View v) {


                try {

                    if (TextUtils.isEmpty(name2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your name...", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(phone2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your phone no...", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addr2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your address...", Toast.LENGTH_SHORT).show();
                   else if (TextUtils.isEmpty(city2.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your city...", Toast.LENGTH_SHORT).show();
                    else{

                        deliver.setName(name2.getText().toString().trim());
                        deliver.setPhone(Integer.parseInt(phone2.getText().toString().trim()));
                        deliver.setAddress(addr2.getText().toString().trim());
                        deliver.setCity(city2.getText().toString().trim());


                        DeliveryRef.push().setValue(deliver);

                        Toast.makeText(getApplicationContext(),"successfully inserted...", Toast.LENGTH_SHORT).show();
                        clearControls();



                    }

                }
                catch(NumberFormatException e){

                    Toast.makeText(getApplicationContext(),"invalid contact number....", Toast.LENGTH_SHORT).show();

                }

            }
        });

        StoreProductInformation();


    }






    private void StoreProductInformation() {




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


    /*    private void SaveProductInfoToDatabase ()
        {
            HashMap<String, Object> productMap = new HashMap<>();

            productMap.put("DeliveryId", DeliveryRandomKey);
            productMap.put("date", saveCurrentdate);
            productMap.put("time", saveCurrentTime);
            productMap.put("CustomerName", Cname);
            productMap.put("PhoneNo", PhoneNo);
            productMap.put("Address", Address);
            productMap.put("City", City);

            DeliveryRef.child(DeliveryRandomKey).updateChildren(productMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent1 = new Intent(DeliveryActivity.this, ConfirmDetailsActivity.class);
                                startActivity(intent1);

                                loadingBar.dismiss();
                                Toast.makeText(DeliveryActivity.this, " Successfull..", Toast.LENGTH_SHORT).show();
                            } else {
                                loadingBar.dismiss();
                                String message = task.getException().toString();
                                Toast.makeText(DeliveryActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


     */
    }
