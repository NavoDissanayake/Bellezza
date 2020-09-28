package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //action bar
        setTitle("Admin Profile ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //add activity
        Button back =(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(Product.this,MainActivity.class);
                startActivity(intent1);

                //Add Toast
                Toast.makeText(Product.this, "Go Back...", Toast.LENGTH_SHORT).show();
            }
        });

        Button facebtn = (Button)findViewById(R.id.facebtn);
        facebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(Product.this,AddFace.class);
                startActivity(intent3);

                //Add Toast
                Toast.makeText(Product.this, "Loading...", Toast.LENGTH_SHORT).show();

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