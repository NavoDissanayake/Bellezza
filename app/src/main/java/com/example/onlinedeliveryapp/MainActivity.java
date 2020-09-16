package com.example.onlinedeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //action bar
        setTitle("Checkout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //next button
        button = findViewById(R.id.button1);
        button.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this,DeliveryActivity.class)));




    }
}