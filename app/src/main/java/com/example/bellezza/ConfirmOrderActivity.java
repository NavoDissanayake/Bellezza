package com.example.bellezza;

import android.annotation.SuppressLint;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ConfirmOrderActivity extends AppCompatActivity {


    Button button,savebtn;
    TextView confirmName, confirmPhone, confirmAddress, confirmCity;
    Delivery deliver;
    TextView txttotal_price2, txttvTotAmountFin, txtdel;
    //int deliveryTot;
   // String totalAmount = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);


        // totalAmount = getIntent().getStringExtra("Total Price");
        //Toast.makeText(this,"Total Price = "+totalAmount+"LKR",Toast.LENGTH_SHORT);

        //action bar
        setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txttotal_price2    = findViewById(R.id.price3);
        txtdel             = findViewById(R.id.price4);
        txttvTotAmountFin  = findViewById(R.id.calculation);

        confirmName    = findViewById(R.id.name2);
        confirmPhone   = findViewById(R.id.phone2);
        confirmAddress = findViewById(R.id.address2);
        confirmCity    = findViewById(R.id.city2);


        deliver = new Delivery();


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference();

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {


            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



           if (dataSnapshot.hasChildren()) {

               confirmName.setText(dataSnapshot.child("Delivery").child("996450325V").child("name").getValue().toString());
               confirmPhone.setText(dataSnapshot.child("Delivery").child("996450325V").child("phone").getValue().toString());
               confirmAddress.setText(dataSnapshot.child("Delivery").child("996450325V").child("address").getValue().toString());
               confirmCity.setText(dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString());

                    //confirmPhone.setText(dataSnapshot.child("phone").getValue().toString());
                   // confirmAddress.setText(dataSnapshot.child("address").getValue().toString());
                   // confirmCity.setText(dataSnapshot.child("city").getValue().toString());

            if(dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("Kandy" ) || dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("kandy" ) ){

                        int del = 150;

                        int tot = Integer.parseInt(dataSnapshot.child("Cart").child("price").getValue().toString()) + del;



                        txttotal_price2.setText("LKR"+dataSnapshot.child("Cart").child("price").getValue().toString());
                        txtdel.setText("LKR"+ del);
                        txttvTotAmountFin.setText("LKR "+ tot);


            }else if (dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("Matale" ) || dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("matale") ) {

                        int del = 250;

                        int tot = Integer.parseInt(dataSnapshot.child("Cart").child("price").getValue().toString()) + del;



                        txttotal_price2.setText("LKR"+dataSnapshot.child("Cart").child("price").getValue().toString());
                        txtdel.setText("LKR"+ del);
                        txttvTotAmountFin.setText("LKR "+ tot);


            }else if (dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("Kurunegala" ) || dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("kurunegala") ) {

                        int del = 300;
                        int tot = Integer.parseInt(dataSnapshot.child("Cart").child("price").getValue().toString()) + del;



                        txttotal_price2.setText("LKR"+dataSnapshot.child("Cart").child("price").getValue().toString());
                        txtdel.setText("LKR"+ del);
                        txttvTotAmountFin.setText("LKR "+ tot);

            }else if (dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("Kegalle" ) || dataSnapshot.child("Delivery").child("996450325V").child("city").getValue().toString().equals("kegalle") ) {

                        int del = 270;
                        int tot = Integer.parseInt(dataSnapshot.child("Cart").child("price").getValue().toString()) + del;



                        txttotal_price2.setText("LKR"+dataSnapshot.child("Cart").child("price").getValue().toString());
                        txtdel.setText("LKR"+ del);
                        txttvTotAmountFin.setText("LKR "+ tot);



            }else{

                        int del = 400;

                        int tot = Integer.parseInt(dataSnapshot.child("Cart").child("price").getValue().toString()) + del;

                        txttotal_price2.setText("LKR" + dataSnapshot.child("Cart").child("price").getValue().toString());
                        txtdel.setText("LKR" + del);
                        txttvTotAmountFin.setText("LKR"+ tot);



                    }


                } else
                    Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        button = findViewById(R.id.button4);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Delivery");

              final String saveCurrentdate,saveCurrentTime;
                Calendar calendar = Calendar.getInstance();
                final SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentdate = currentDate.format(calendar.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                saveCurrentTime = currentTime.format(calendar.getTime());



                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                        if(datasnapshot.hasChild("996450325V")){

                            try {


                                deliver.setName(confirmName.getText().toString().trim());
                                deliver.setPhone(confirmPhone.getText().toString().trim());
                                deliver.setAddress(confirmAddress.getText().toString().trim());
                                deliver.setCity(confirmCity.getText().toString().trim());
                                deliver.setTotal(txttvTotAmountFin.getText().toString().trim());
                                deliver.setDate(saveCurrentdate);
                                deliver.setTime(saveCurrentTime);



                                DatabaseReference delref = FirebaseDatabase.getInstance().getReference().child("Delivery").child("996450325V");



                                delref.setValue(deliver);

                                //Feedback to the user via a Toast
                               // Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();

                            }catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();



                            }




                        }else

                            Toast.makeText(getApplicationContext(),"No Source to Update", Toast.LENGTH_SHORT).show();


                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




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




    protected int finalTotCal(int  txtdel  , int txttvTotAmountFin){

        return txtdel+ txttvTotAmountFin;

    }

}



