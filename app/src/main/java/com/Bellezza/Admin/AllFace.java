package com.Bellezza.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class AllFace extends AppCompatActivity {

    EditText AddName,AddDesc,AddPrice,AddDate;
    Spinner spinnerBrands;

    DatabaseReference dbRef;
    ListView listViewFace;
    List<Face> faceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_face);

        listViewFace.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Face face = faceList.get(position);
                showUpdateDialog(face.getFaceId(), face.getFaceName());

                return false;
            }
        });

    }
    @Override
    protected void onStart() {
        //attaching value
        super.onStart();

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot faceSnapshot: dataSnapshot.getChildren()){

                    Face face=faceSnapshot.getValue(Face.class);
                    faceList.add(face);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
            FaceList adapter = new FaceList(AllFace.this, faceList);
                listViewFace.setAdapter(adapter);
        }




    private void showUpdateDialog(final String faceId , String FaceName){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater= getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);


        final EditText AddName=(EditText)dialogView.findViewById(R.id.face_name);
        final EditText AddDesc = (EditText)dialogView.findViewById(R.id.face_des);
        final EditText AddPrice = (EditText)dialogView.findViewById(R.id.face_price);
        final EditText AddDate = (EditText)dialogView.findViewById(R.id.date);
        final Button buttonUpdate = (Button)dialogView.findViewById(R.id.buttonUpdate);
        final Spinner spinnerBrands = (Spinner)dialogView.findViewById(R.id.spinnerBrands) ;
        final Button buttonDelete = (Button)dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Updating Product Name   :" + FaceName);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = AddName.getText().toString().trim();
                String desc=AddDesc.getText().toString().trim();
                String price =AddPrice.getText().toString().trim();
                String date=AddDate.getText().toString().trim();
                String brands=spinnerBrands.getSelectedItem().toString();

                if (TextUtils.isEmpty(name)){

                    AddName.setError("Please Enter Name");
                    return;
                }
                updateFace(faceId ,name,brands,desc,price,date );

                alertDialog.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFace(faceId);

            }
        });

    }

    private void deleteFace(String faceId) {
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("faces").child(faceId);

        dr.removeValue();

        Toast.makeText(this,"Product Deleted",Toast.LENGTH_SHORT).show();
    }

    private boolean updateFace(String id,String name,String brands,String desc,String price,String date){
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("faces").child(id);

        Face face = new Face(id,name,brands,desc,price,date);
        databaseReference.setValue(face);

        Toast.makeText(this,"New Product Updated...",Toast.LENGTH_SHORT).show();
        return true;

    }

}