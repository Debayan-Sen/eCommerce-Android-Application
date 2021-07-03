package com.example.c4u2.prevalent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.c4u2.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderViewHolder> {
    Context context;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        Context context;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        switch (position){
            case 0:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fslideitem_image-1.webp?alt=media&token=71abfd61-f5dc-4c15-ac44-d5a0b61b1fee")
                        .into(viewHolder.sliderImageView);
                break;
            case 1:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fslideitem_image-2.webp?alt=media&token=23c5b38e-0c96-419e-87d7-06f428aba3c2")
                        .into(viewHolder.sliderImageView);
                break;
            case 2:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fslideitem_image-3.webp?alt=media&token=1c490968-a09d-4ef9-a92d-61313881c0d3")
                        .into(viewHolder.sliderImageView);
                break;
            case 3:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fslideitem_image-4.webp?alt=media&token=e5926935-478b-43c1-a22e-54dba2583d38")
                        .into(viewHolder.sliderImageView);
                break;
            case 4:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fslideitem_image-5.webp?alt=media&token=f4bdd8d1-8309-40c9-8422-00d1d05b1198")
                        .into(viewHolder.sliderImageView);
                break;
            case 5:
                Glide.with(viewHolder.itemView).load("https://firebasestorage.googleapis.com/v0/b/c4u2ecraft.appspot.com/o/home%2Fslider%2Fblock_three_collections_collection_3_cover%20-%20Copy.webp?alt=media&token=92e886f4-4aac-4f78-ba61-c806d19f3e29")
                        .into(viewHolder.sliderImageView);
                break;
            /*case 6:
                Glide.with(viewHolder.itemView).load("")
                        .into(viewHolder.sliderImageView);*/
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView sliderImageView;
        View itemView;
        public SliderViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            sliderImageView = itemView.findViewById(R.id.imageViewSlider);
        }
    }

}
