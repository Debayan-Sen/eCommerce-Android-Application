package com.example.c4u2.prevalent;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c4u2.Model.Products;
import com.example.c4u2.ProductDetails;
import com.example.c4u2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class Adapters extends FirebaseRecyclerAdapter<Products, Adapters.PostviewHolder> {

    public Adapters(@NonNull  FirebaseRecyclerOptions<Products> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostviewHolder holder, int position, @NonNull final Products model) {

        holder.textTitle.setText(model.getNAME());
        holder.textPrice.setText(model.getPRICE());
        Picasso.get().load(model.getIMAGE()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //context   view.getContext()
                Intent intent = new Intent(view.getContext(),ProductDetails.class);
                intent.putExtra("PPrice",model.getPRICE());
                intent.putExtra("PName",model.getNAME());
                intent.putExtra("PDescription",model.getDESCRIPTION());
                intent.putExtra("PImage",model.getIMAGE());
                intent.putExtra("PID",model.getPID());
                view.getContext().startActivity(intent);
                //Toast.makeText(view.getContext(), model.getPRICE()+" is the price", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public PostviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view, parent, false);

        return new PostviewHolder(view);
    }

    public class PostviewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textPrice,textDescription;
        ImageView imageView;

        public PostviewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.cart_product_name);
            textPrice = itemView.findViewById(R.id.cart_product_Price);
            textDescription = itemView.findViewById(R.id.productDescription);
            imageView = itemView.findViewById(R.id.imageView);

        }

    }

}



