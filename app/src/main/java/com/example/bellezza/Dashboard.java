package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    ListView listView;
    FirebaseDatabase db;
    DatabaseReference dbref;
    ArrayList<Face>list;
    ArrayAdapter<Face> adapter;
    Face face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        listView = (ListView)findViewById(R.id.list);
        db= FirebaseDatabase.getInstance();
        dbref=db.getReference("faces");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<Face>(this,R.layout.productinfo,R.id.face_name,list);

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot da: dataSnapshot.getChildren())
                {
                    face=da.getValue(Face.class);
                    list.add(face);
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}