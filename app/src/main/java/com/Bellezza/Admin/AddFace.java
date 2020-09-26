package com.Bellezza.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddFace extends AppCompatActivity {

    EditText AddName,AddDesc,AddPrice,AddDate;
    Button btnAdd;
    Spinner spinnerBrands;

    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_face);

        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //action bar
        setTitle("Add Face Products.. ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        dbRef = FirebaseDatabase.getInstance().getReference("faces");


        AddName = (EditText) findViewById(R.id.face_name);
        AddDesc = (EditText) findViewById(R.id.face_des);
        AddPrice=(EditText) findViewById(R.id.face_price);
        AddDate=(EditText) findViewById(R.id.date);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        spinnerBrands=(Spinner)findViewById(R.id.spinnerBrands);

        //listViewFace=(ListView)findViewById(R.id.listViewFace);
        //faceList= new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFace();

            }
        });


    }

    //saving Face Product Data to the database
    private void addFace(){
        //getting the values to save

        String name = AddName.getText().toString().trim();
        String brands= spinnerBrands.getSelectedItem().toString();
        String desc =AddDesc.getText().toString().trim();
        String price =AddPrice.getText().toString().trim();
        String date =AddPrice.getText().toString().trim();

        //checking
        if (!TextUtils.isEmpty(name)){

            //getting the unique id using push().getKey() method
            //it create Id As a primary key
            String id= dbRef.push().getKey();

            //creating an face object
            Face face = new Face(id, name ,brands,desc,price,date);

            //saving face
            dbRef.child("Face").setValue(face);

            //displaying Success toast
            Toast.makeText(this,"Product Added",Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(AddFace.this,AllFace.class);
            startActivity(intent);

        }else{
            //if the value is not given displaying toast
            Toast.makeText(this,"You Should Enter Name",Toast.LENGTH_SHORT).show();;
        }
    }
}