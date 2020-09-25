package com.example.onlinedeliveryapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class ConfirmOrderActivity extends AppCompatActivity {


    Button button;
    TextView confirmName, confirmPhone, confirmAddress, confirmCity;
    Delivery deliver;
    //TextView  txttotal_price2, txttvTotAmountFin, txtdel;
    // private int deliveryTot   ;
    // private String totalAmount = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);


        //totalAmount = getIntent().getStringExtra("Total Price");
        //Toast.makeText(this,"Total Price = "+totalAmount+"LKR",Toast.LENGTH_SHORT);

        //action bar
        setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //   txttotal_price2 = findViewById(R.id.price3) ;
        //  txttvTotAmountFin = findViewById(R.id.price4);

        confirmName = findViewById(R.id.name2);
        confirmPhone = findViewById(R.id.phone2);
        confirmAddress = findViewById(R.id.address2);
        confirmCity = findViewById(R.id.city2);


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

             /*       if(dataSnapshot.child("city").getValue().toString().equals("Kandy" ) || dataSnapshot.child("city").getValue().toString().equals("kandy") ){

                        int del = 150;

                        int tot = Integer.parseInt(dataSnapshot.child("price").getValue().toString()) + del;

                        txttotal_price2.setText("LKR"+dataSnapshot.child("price").getValue().toString());
                        txtdel.setText("LKR"+Integer.toString(del));
                       txttvTotAmountFin.setText("LKR"+ tot);

                    }else if (dataSnapshot.child("city").getValue().toString().equals("Matale" ) || dataSnapshot.child("city").getValue().toString().equals("matale") ) {

                        int del = 250;

                        int tot = Integer.parseInt(dataSnapshot.child("price").getValue().toString()) + del;

                        txttotal_price2.setText("LKR"+dataSnapshot.child("price").getValue().toString());
                        txtdel.setText("LKR"+Integer.toString(del));
                        txttvTotAmountFin.setText("LKR"+Integer.toString(tot));


                    }else if (dataSnapshot.child("city").getValue().toString().equals("Kurunegala" ) || dataSnapshot.child("city").getValue().toString().equals("kurunegala") ) {

                        int del = 300;

                        int tot = Integer.parseInt(dataSnapshot.child("price").getValue().toString()) + del;

                        txttotal_price2.setText("LKR"+dataSnapshot.child("price").getValue().toString());
                        txtdel.setText("LKR"+Integer.toString(del));
                       txttvTotAmountFin.setText("LKR"+Integer.toString(tot));


                    }else if (dataSnapshot.child("city").getValue().toString().equals("Kegalle" ) || dataSnapshot.child("city").getValue().toString().equals("kegalle") ) {

                        int del = 270;

                        int tot = Integer.parseInt(dataSnapshot.child("price").getValue().toString()) + del;

                       txttotal_price2.setText("LKR" + dataSnapshot.child("price").getValue().toString());
                        txtdel.setText("LKR" + Integer.toString(del));
                        txttvTotAmountFin.setText("LKR" + Integer.toString(tot));


                    }else {

                        int del = 400;

                        int tot = Integer.parseInt(dataSnapshot.child("price").getValue().toString()) + del;

                       txttotal_price2.setText("LKR" + dataSnapshot.child("price").getValue().toString());
                        txtdel.setText("LKR" + Integer.toString(del));
                        txttvTotAmountFin.setText("LKR" + Integer.toString(tot));


                    }

                    // txttotal_price2.setText("LKR"+dataSnapshot.child("totalAmount").getValue().toString());
                    // txtdel.setText("LKR"+dataSnapshot.child("deliveryTot").getValue().toString());
                    //  txttvTotAmountFin.setText("LKR"+dataSnapshot.child("finalTot").getValue().toString());
*/


                } else
                    Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






/*
        //confirm button

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
*/

        //Alert
        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrderActivity.this);

                //set title
                builder.setTitle("Bellezza");
                //set icon
                // builder.setIcon(R.drawable.plus);

                //set Message
                builder.setMessage("Your final order has already been placed.Soon it will be verified.Thank You.");

                //set positive
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close the activity when this button is clicked
                        ConfirmOrderActivity.this.finish();
                    }
                });


                //create alert dialog
                AlertDialog alertDialog = builder.create();
                //show alert dialog
                alertDialog.show();
            }
        });


    }

}