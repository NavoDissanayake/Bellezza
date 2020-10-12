package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //action bar
        setTitle("Admin Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //add activity
        Button button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(Admin.this,Product.class);
                startActivity(intent1);

                //Add Toast
                Toast.makeText(Admin.this, "Open Product...", Toast.LENGTH_SHORT).show();
            }
        });




        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(Admin.this,Other.class);
                startActivity(intent2);

                //Add Toast
                Toast.makeText(Admin.this, "Loading Other...", Toast.LENGTH_SHORT).show();

            }
        });




    }
    //back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
        //Add Toast
    }
}