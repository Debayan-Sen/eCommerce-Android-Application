package com.example.c4u2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Decor_Fragment extends Fragment implements View.OnClickListener {

    private ImageView dec1,dec2,dec3,dec4,dec5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_decor, container, false);

        dec1 = v.findViewById(R.id.dec1);
        dec2 = v.findViewById(R.id.dec2);
        dec3 = v.findViewById(R.id.dec3);
        dec4 = v.findViewById(R.id.dec4);
        dec5 = v.findViewById(R.id.dec5);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/dechome%2Fblock_four_banner_bottom_2_image%20-%20Copy.webp?alt=media&token=b182d85f-6642-459d-901e-2f325d2036c1").into(dec1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/dechome%2Fmegamenu_image-5%20-%20Copy.webp?alt=media&token=ebcd0077-23d0-452b-8553-120a71fad56b").into(dec2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/dechome%2Fblock_four_banner_bottom_1_image%20-%20Copy.webp?alt=media&token=35352b8b-5995-447e-9ecc-9794ac886a4e").into(dec3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/dechome%2FIRKWH501_main_24039a9e-7475-43a4-b84c-0abc5b539c74_1024x1024.jpg?alt=media&token=178f12a2-10da-4865-b3a9-b8dca8653c9d").into(dec4);
        dec1.setOnClickListener(this);
        dec2.setOnClickListener(this);
        dec3.setOnClickListener(this);
        dec4.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dec1:
                Intent intent = new Intent(getActivity(),ProductRecycleView.class);
                intent.putExtra("swValue",21);
                startActivity(intent);
                break;
            case R.id.dec2:
                Intent intent2 = new Intent(getActivity(),ProductRecycleView.class);
                intent2.putExtra("swValue",22);
                startActivity(intent2);
                break;
            case R.id.dec3:
                Intent intent3 = new Intent(getActivity(),ProductRecycleView.class);
                intent3.putExtra("swValue",23);
                startActivity(intent3);
                break;
            case R.id.dec4:
                Intent intent4 = new Intent(getActivity(),ProductRecycleView.class);
                intent4.putExtra("swValue",24);
                startActivity(intent4);
                break;
        }
    }
}
