package com.example.c4u2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.c4u2.Model.ImageSliderModel;
import com.example.c4u2.prevalent.ImageSliderAdapter;
import com.google.firebase.database.DatabaseReference;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment implements View.OnClickListener {

    private DatabaseReference databaseReference;
    private SliderView sliderView;
    private ImageView fimg1,fimg2,fimg3,fimg4,IV1,IV2,IV3,ad;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shop, container, false);



        //show
        IV1 = v.findViewById(R.id.IV1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fshow%2FFR1D4TL1AOL_RD_main_1024x1024.jpg?alt=media&token=2799e9ab-abdc-4a6e-bd3d-4f799c12c972").into(IV1);
        IV2 = v.findViewById(R.id.IV2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fshow%2FAGG506_main_w_22190e53-939c-4ec2-92cb-df86095c9afb_1024x1024.webp?alt=media&token=d418c6d3-e3c9-4796-af4c-ed160f1b0539").into(IV2);
        IV3 = v.findViewById(R.id.IV3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fshow%2FKWC564_main_1024x1024.webp?alt=media&token=aea1ce27-c617-49b2-8ac5-c501e6959a50").into(IV3);
        IV1.setOnClickListener(this);
        IV2.setOnClickListener(this);
        IV3.setOnClickListener(this);
        //show


        //slide
        sliderView = v.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new ImageSliderAdapter(getContext()));
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.setIndicatorRadius(4);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        //slide

        //featured
        fimg1 = v.findViewById(R.id.featureImage1);
        fimg2 = v.findViewById(R.id.featureImage2);
        fimg3 = v.findViewById(R.id.featureImage3);
        fimg4 = v.findViewById(R.id.featureImage4);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/pot%26vases%2FMPV502_main_49e51918-e023-465e-b952-5581010baddc_1024x1024.webp?alt=media&token=1130b765-ee79-4e41-a8a8-e08cf4fb6813")
                .into(fimg1);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/Buddha%2FMSGB585_GR_main_hd_951bd440-954b-4a5d-acc7-104a6928df77_1024x1024.webp?alt=media&token=24f3f200-e861-45ce-a10f-c59eeb853bf9")
                .into(fimg2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/wallhang%2FIBG500_main_hd_1024x1024.jpg?alt=media&token=8097048b-f55b-4cbe-b9f4-59bcc65c630e")
                .into(fimg3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Ffeatured%2FC4FPB2119_main_7972dc2e-ad54-4e89-b648-0dd65d6f0ac6_1024x1024.webp?alt=media&token=ee406183-57c7-4ec3-b268-31a55cec3409")
                .into(fimg4);
        fimg1.setOnClickListener(this);
        fimg2.setOnClickListener(this);
        fimg3.setOnClickListener(this);
        fimg4.setOnClickListener(this);
        //featured

        //ad
        ad = v.findViewById(R.id.ad);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fshow%2Fbanner%2Fslideitem_image-9.webp?alt=media&token=ae56bf40-0d28-4250-b748-7e2f538d30b1").into(ad);
        //ad

        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.featureImage1):
                Intent intent = new Intent(getActivity(),ProductRecycleView.class);
                intent.putExtra("swValue",1);
                startActivity(intent);
                break;
            case (R.id.featureImage2):
                Intent intent2 = new Intent(getActivity(),ProductRecycleView.class);
                intent2.putExtra("swValue",2);
                startActivity(intent2);
                break;
            case (R.id.featureImage3):
                Intent intent3 = new Intent(getActivity(),ProductRecycleView.class);
                intent3.putExtra("swValue",3);
                startActivity(intent3);
                break;
            case (R.id.featureImage4):
                Intent intent4 = new Intent(getActivity(),ProductRecycleView.class);
                intent4.putExtra("swValue",4);
                startActivity(intent4);
                break;
            case R.id.IV1:
                Intent intent5 = new Intent(getActivity(),ProductRecycleView.class);
                intent5.putExtra("swValue",11);
                startActivity(intent5);
                break;
            case R.id.IV2:
                Intent intent6 = new Intent(getActivity(),ProductRecycleView.class);
                intent6.putExtra("swValue",12);
                startActivity(intent6);
                break;
            case R.id.IV3:
                Intent intent7 = new Intent(getActivity(),ProductRecycleView.class);
                intent7.putExtra("swValue",13);
                startActivity(intent7);
                break;
        }
    }


}