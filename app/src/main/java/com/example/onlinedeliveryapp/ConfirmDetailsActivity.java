package com.example.onlinedeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;



public class ConfirmDetailsActivity extends AppCompatActivity {
    private Button button;
    private Button btn;
    private TextView  name3,phone3,address3,city3;
    private String iname,iphone,iaddress,icity;
    private DataSnapshot dataSnapshot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);


        TextView textView = findViewById(R.id.text_view);

        name3 = findViewById(R.id.name2);
        phone3= findViewById(R.id.phone2);
        address3 = findViewById(R.id.address2);
        city3 = findViewById(R.id.city2);
        button = findViewById(R.id.button3);
        registerForContextMenu(textView);


        Intent intent3 = getIntent();

        String user_name = intent3.getStringExtra("name");
        String user_phoneNo = intent3.getStringExtra("phone");
        String user_address = intent3.getStringExtra("address");
        String user_city = intent3.getStringExtra("city");

        name3.setText(user_name);
        phone3.setText(user_phoneNo);
        address3.setText(user_address );
        city3.setText(user_city);

        //showAllUserData();

        SpannableString content = new SpannableString("Options");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);





        //action bar
        setTitle("Confirm Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //next button;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmDetailsActivity.this, ConfirmOrderActivity.class);

                startActivity(i);


            }
        });


    }






   /*private void showAllUserData() {

        Intent intent3 = getIntent();

        String user_name = intent3.getStringExtra("name");
        String user_phoneNo = intent3.getStringExtra("phone");
        String user_address = intent3.getStringExtra("address");
        String user_city = intent3.getStringExtra("city");

        name3.setText(user_name);
        phone3.setText(user_phoneNo);
        address3.setText(user_address );
        city3.setText(user_city);


    }

*/



    //contex menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.op_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_2:
                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }




}


