package com.example.bellezza;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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


        Face face= faceList.get(position);

        textViewName.setText(face.getFaceName());
        textViewBrand.setText(face.getFaceBrand());

        return listViewItem;
    }

}
