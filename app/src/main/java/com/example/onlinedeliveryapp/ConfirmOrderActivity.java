package com.example.onlinedeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmOrderActivity extends AppCompatActivity {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);


        //action bar
        setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //confirm button
        button = (Button)findViewById(R.id.button4);
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


}
