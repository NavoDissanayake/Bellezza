package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    String s1[], s2[] , s3[];
    int images[] ={R.drawable.pureskin,R.drawable.loreal,R.drawable.glam,R.drawable.buttr,R.drawable.nive,
                    R.drawable.hair,R.drawable.foot,R.drawable.lipstick,R.drawable.mascar};

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recycleView);

        s1=getResources().getStringArray(R.array.face_products);
        s2=getResources().getStringArray(R.array.Brand);
        s3=getResources().getStringArray(R.array.Price);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}