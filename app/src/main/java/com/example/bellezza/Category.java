package com.example.bellezza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryListRecyclerView = findViewById(R.id.categoryListRecyclerView);
        categoryListRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        FirebaseRecyclerOptions<Face> options2 =
                new FirebaseRecyclerOptions.Builder<Face>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("faces"), Face.class)
                        .build();


        adapter1 = new CategoryListDisplayAdapter(options2);
        categoryListRecyclerView.setAdapter(adapter1);


        // categoryListRecyclerView.


    }

    protected  void onStart() {

        super.onStart();

        adapter1.startListening();
    }

    protected  void onStop() {

        super.onStop();

        adapter1.stopListening();






    Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category.this,Admin.class);
                startActivity(intent);
            }
        });
    }




}