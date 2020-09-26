package com.Bellezza.Admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class FaceList extends ArrayAdapter {

    private Activity context;
    private List<Face> faceList;

    public FaceList(Activity context,List<Face> faceList){
        super(context, R.layout.listlayout,faceList);
        this.context = context;
        this.faceList=faceList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.listlayout,null,true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewBrand = (TextView) listViewItem.findViewById(R.id.textViewBrand);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.textViewDesc);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);


        Face face= faceList.get(position);

        textViewName.setText(face.getFaceName());
        textViewBrand.setText(face.getFaceBrand());
        textViewDesc.setText(face.getFaceDesc());
        textViewPrice.setText(face.getFacePrice());

        return listViewItem;
    }

}
