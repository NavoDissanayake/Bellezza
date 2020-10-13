package com.example.bellezza;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ConfirmDetailsActivity extends AppCompatActivity {


    private Button Confirmbutton,updtebutton,delbutton;
    private Button btn;
    private EditText name3, phone3, address3, city3;
    private DataSnapshot dataSnapshot;
    DatabaseReference DeliveryRef;
    Delivery deliver;
    private String key;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);


        //TextView textView = findViewById(R.id.text_view);

        //edit text
        name3 = findViewById(R.id.textName);
        phone3 = findViewById(R.id.textPhone);
        address3 = findViewById(R.id.textAddress);
        city3 = findViewById(R.id.textCity);


        //buttons
        Confirmbutton = findViewById(R.id.button3);
        updtebutton=findViewById(R.id.updatebtn);
        delbutton=findViewById(R.id.deletebtn);
        // registerForContextMenu(textView);
        deliver = new Delivery();



        //action bar
        setTitle("Confirm Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        key = getIntent().getStringExtra("key").toString();
        FirebaseAuth auth;
        DatabaseReference addRef;

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child(key);

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {

                    name3.setText(dataSnapshot.child("name").getValue().toString());
                    phone3.setText(dataSnapshot.child("phone").getValue().toString());
                    address3.setText(dataSnapshot.child("address").getValue().toString());
                    city3.setText(dataSnapshot.child("city").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "No Source to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        //next button
        Confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmDetailsActivity.this, ConfirmOrderActivity.class);
                i.putExtra("key",key);
                startActivity(i);
            }
        });






        //click update button
        updtebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                onUpdateDetailsClick();
            }
        });


        //click delete button
        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                onDeleteDetailsClick();
            }
        });




    }




    //update details with alert
    private void onUpdateDetailsClick() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are sure want to update details?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {




                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(key)){
                            try{
                                deliver.setName(name3.getText().toString().trim());
                                deliver.setPhone(phone3.getText().toString().trim());
                                deliver.setAddress(address3.getText().toString().trim());
                                deliver.setCity(city3.getText().toString().trim());

                                DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child(key);
                                DeliveryRef.setValue(deliver);
                                //Feedback to the user via a Toast
                                Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                            }
                            catch(NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Update", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();



    }





    //delete the details with alert
    private void onDeleteDetailsClick(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are sure want to delete details?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){

                            DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child(key);
                            DeliveryRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                            viewprevious();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }


    private void clearControls(){


        name3.setText("");
        phone3.setText("");
        address3.setText("");
        city3.setText("");

    }


    private  void viewprevious(){

        Intent i = new Intent(ConfirmDetailsActivity.this, DeliveryActivity.class);

        startActivity(i);


    }
}








