package com.example.bellezza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminReg extends AppCompatActivity {

    EditText Adname,Adpass,Ademail,Adphone,Adnic;
    Button sinup,loging;


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reg);
//add activity
        Button button = (Button)findViewById(R.id.loging);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(AdminReg.this ,AdminLogin.class);
                startActivity(intent9);

                //Add Toast
                Toast.makeText(AdminReg.this, "Loading...", Toast.LENGTH_SHORT).show();
            }
        });




        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");


        Adname = (EditText) findViewById(R.id.name);
        Ademail = (EditText) findViewById(R.id.Email);
        Adphone=(EditText) findViewById(R.id.phone);
        Adnic=(EditText) findViewById(R.id.Email);
        Adpass=(EditText) findViewById(R.id.pass);
       sinup = (Button)findViewById(R.id.sinup);

        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Administrator();
            }
        });


    }

    private void Administrator(){

        //getting the values to save

        String name = Adname.getText().toString().trim();
        String email= Ademail.getText().toString().trim();
        String nic= Adnic.getText().toString().trim();
        String phone =Adphone.getText().toString().trim();
        String pwd =Adpass.getText().toString().trim();

//checking
        if (!TextUtils.isEmpty(name)){

            //getting the unique id using push().getKey() method
            //it create Id As a primary key
            String id= databaseReference.push().getKey();

            //creating
            Administrator administrator = new Administrator(id, name ,email,phone,pwd);

            //saving
            databaseReference.child(id).setValue(administrator);

            //displaying Success toast
            Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show();


        }else{
            //if the value is not given displaying toast
            Toast.makeText(this,"You Should Enter Name",Toast.LENGTH_SHORT).show();;
        }


    }
}