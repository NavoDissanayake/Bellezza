package com.example.onlinedeliveryapp;

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


public class ConfirmDetailsActivity extends AppCompatActivity {
    private Button button;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);


        TextView textView = findViewById(R.id.text_view);
        registerForContextMenu(textView);

        SpannableString content = new SpannableString("Options");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        //action bar
        setTitle("Confirm Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //next button
        View button = findViewById(R.id.button3);
        button.setOnClickListener(v ->
                startActivity(new Intent(ConfirmDetailsActivity.this, ConfirmOrderActivity.class)));






    }




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


