package com.example.bellezza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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



       /* SpannableString content = new SpannableString("Options");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

*/


        //action bar
        setTitle("Confirm Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("996450325V");

        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {

                    name3.setText(dataSnapshot.child("name").getValue().toString());
                    phone3.setText(dataSnapshot.child("phone").getValue().toString());
                    address3.setText(dataSnapshot.child("address").getValue().toString());
                    city3.setText(dataSnapshot.child("city").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "No source to Display", Toast.LENGTH_SHORT).show();
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

                startActivity(i);


            }
        });








       //update details
        updtebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("996450325V")){


                            try{



                                deliver.setName(name3.getText().toString().trim());
                                deliver.setPhone(phone3.getText().toString().trim());
                                deliver.setAddress(address3.getText().toString().trim());
                                deliver.setCity(city3.getText().toString().trim());



                                DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("996450325V");


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
        });












        //delete details
        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Delivery");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){

                            DeliveryRef = FirebaseDatabase.getInstance().getReference().child("Delivery").child("delivery1");
                            DeliveryRef.removeValue();
                           // clearControls();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }





 //   private void clearControls() {


  //      name3.setText("");
  //      phone3.setText("");
  //      address3.setText("");
  //      city3.setText("");

   // }

}



    //contex menu
  // @Override
 // public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       // super.onCreateContextMenu(menu, v, menuInfo);
        //menu.setHeaderTitle("Choose your option");
       // getMenuInflater().inflate(R.menu.op_menu, menu);
    //}


   // @Override
   // public boolean onContextItemSelected(MenuItem item) {
   //     switch (item.getItemId()) {
        //    case R.id.option_1:
         //       Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
          //      return true;
           // case R.id.option_2:
           //     Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
           //     return true;
           // default:
           //     return super.onContextItemSelected(item);
        //}


  //  }






