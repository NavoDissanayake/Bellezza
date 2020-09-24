package com.example.onlinedeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toolbar;
import android.view.View;


import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    Button button;
    DrawerLayout drawer;
    NavigationView nav_view;
    ActionBarDrawerToggle actionbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar= findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




         drawer = findViewById(R.id.drawer_layout);
         actionbar = new ActionBarDrawerToggle(MainActivity.this,drawer,R.string.draw_open,R.string.draw_close);
         drawer.addDrawerListener(actionbar);
         nav_view =findViewById(R.id.nav_view);
        // View nav = nav_view.inflateHeaderView(R.id.layout.navdrawable);

        View header = LayoutInflater.from(this).inflate(R.layout.navdrawable, null);
        nav_view.addHeaderView(header);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                UsermenuSelected(item);
                return false;
            }
        });


       /* //action bar
        setTitle("Checkout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/



        //next button
       /* button = findViewById(R.id.button1);
        button.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this,DeliveryActivity.class)));*/




    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionbar.onOptionsItemSelected(item)){

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void  UsermenuSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
             break;
            case R.id.profile:
                break;
            case R.id.cart:
                break;


        }




    }

   
}