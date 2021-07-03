package com.example.c4u2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Furniture_Fragment extends Fragment implements View.OnClickListener {

    ImageView fur1,fur2,fur3,fur4,fur5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_furniture, container, false);

        fur1 = v.findViewById(R.id.fur1);
        fur2 = v.findViewById(R.id.fur2);
        fur3 = v.findViewById(R.id.fur3);
        fur4 = v.findViewById(R.id.fur4);
        fur5 = v.findViewById(R.id.fur5);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/fuhome%2Fslideitem_image-6.webp?alt=media&token=8302324c-a6b5-4bf9-9c5e-e023eba844d6").into(fur1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/fuhome%2Fmegamenu_image-2.webp?alt=media&token=c86e11c7-4225-4e98-ada6-5e62dc2d2a6a").into(fur2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/fuhome%2Fmegamenu_image-6.webp?alt=media&token=1c870b8a-15e8-4f33-881f-26afbd24ce6d").into(fur3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/fuhome%2Fij_halfxhalf.2359099220_g9ffwnor.jpg?alt=media&token=0ff27bc9-a179-4fd0-9c31-04f8a27cf58d").into(fur4);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/fuhome%2Fslideitem_image-7.webp?alt=media&token=d537d953-088c-49e9-a64d-21cdf898ddfc").into(fur5);
        fur1.setOnClickListener(this);
        fur2.setOnClickListener(this);
        fur3.setOnClickListener(this);
        fur4.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fur1:
                Intent intent = new Intent(getActivity(),ProductRecycleView.class);
                intent.putExtra("swValue",31);
                startActivity(intent);
                break;
            case R.id.fur2:
                Intent intent2 = new Intent(getActivity(),ProductRecycleView.class);
                intent2.putExtra("swValue",32);
                startActivity(intent2);
                break;
            case R.id.fur3:
                Intent intent3 = new Intent(getActivity(),ProductRecycleView.class);
                intent3.putExtra("swValue",33);
                startActivity(intent3);
                break;
            case R.id.fur4:
                Intent intent4 = new Intent(getActivity(),ProductRecycleView.class);
                intent4.putExtra("swValue",34);
                startActivity(intent4);
                break;
        }
    }
}
