package com.example.c4u2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Painting_Fragment extends Fragment implements View.OnClickListener {

    ImageView pai1, pai2, pai3, pai4, pai5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_painting, container, false);

        pai1 = v.findViewById(R.id.pai1);
        pai2 = v.findViewById(R.id.pai2);
        pai3 = v.findViewById(R.id.pai3);
        pai4 = v.findViewById(R.id.pai4);
        //pai5 = v.findViewById(R.id.fur5);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/paihome%2Fblock_four_banner_bottom_4_image.webp?alt=media&token=70f1b863-bd95-46c2-bcb2-2033c3edb794")
                .into(pai1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/paihome%2Fmegamenu_image-4.webp?alt=media&token=6087c5d5-c52c-48c8-b4d1-2594d5a753f0")
                .into(pai2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/paihome%2FMPTCD138_main_hd_41a9e8f0-92ee-4744-9fd9-9442d6a5a91c_1024x1024.jpg?alt=media&token=c9fe1e3d-1018-40d5-9798-49c64a9fc342")
                .into(pai3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/paihome%2FEPHB02_main_5093fbb0-8ffc-4c1f-8f34-2d7a9db0c391_1024x1024.webp?alt=media&token=a5004e58-47d9-4c53-9323-ccc2b511eb96")
                .into(pai4);
        pai1.setOnClickListener(this);
        pai2.setOnClickListener(this);
        pai3.setOnClickListener(this);
        pai4.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pai1:
                Intent intent = new Intent(getActivity(),ProductRecycleView.class);
                intent.putExtra("swValue",41);
                startActivity(intent);
                break;
            case (R.id.pai2):
                Intent intent2 = new Intent(getActivity(),ProductRecycleView.class);
                intent2.putExtra("swValue",42);
                startActivity(intent2);
                break;
            case (R.id.pai3):
                Intent intent3 = new Intent(getActivity(),ProductRecycleView.class);
                intent3.putExtra("swValue",43);
                startActivity(intent3);
                break;
            case (R.id.pai4):
                Intent intent4 = new Intent(getActivity(),ProductRecycleView.class);
                intent4.putExtra("swValue",1);
                startActivity(intent4);
                break;
        }
    }
}
