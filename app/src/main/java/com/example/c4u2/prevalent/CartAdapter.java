package com.example.c4u2.prevalent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c4u2.MainActivity;
import com.example.c4u2.Model.Cart;
import com.example.c4u2.Model.User;
import com.example.c4u2.ProductDetails;
import com.example.c4u2.R;
import com.example.c4u2.my_cart_Main2Activity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class CartAdapter extends FirebaseRecyclerAdapter<Cart, CartAdapter.PostviewHolder> {

    String ph,idcart,Qty;
    int overTotalPrice=0;
    public CartAdapter(@NonNull FirebaseRecyclerOptions<Cart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final PostviewHolder holder, int position, @NonNull final Cart model) {

        holder.textTitleCart.setText(model.getPName());
        holder.textPriceCart.setText(model.getPPrice());
        holder.textIDCart.setText(model.getPID());
        Picasso.get().load(model.getPImage()).into(holder.imageViewCart);

        //int oneTypeProductTotalPrice = (Integer.valueOf(model.getPPrice()))*(Integer.valueOf(Qty));
        //overTotalPrice = overTotalPrice + oneTypeProductTotalPrice;


        idcart = model.getPID();

        getph();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {    //context   view.getContext()

                CharSequence options[] = new CharSequence[]{
                        "View Product","Remove Product"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Cart Options:");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(i==0) {
                            Intent intent = new Intent(view.getContext(), ProductDetails.class);
                            intent.putExtra("PPrice", model.getPPrice());
                            intent.putExtra("PName", model.getPName());
                            intent.putExtra("PDescription", model.getPDescription());
                            intent.putExtra("PImage", model.getPImage());
                            intent.putExtra("PID", model.getPID());
                            view.getContext().startActivity(intent);

                        }
                        if(i==1) {
                            //Toast.makeText(view.getContext(), ph+idcart, Toast.LENGTH_SHORT).show();
                            FirebaseDatabase.getInstance().getReference().child("CART LIST").child(ph).child(idcart).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(view.getContext(), "REMOVED FROM CART", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
                builder.show();


            }
        });

    }

    private void getph() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();
        DatabaseReference dataref= FirebaseDatabase.getInstance().getReference().child("Users");
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ph = snapshot.child(uid).child("pHone").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @NonNull
    @Override
    public PostviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_items_layout, parent, false);

        return new PostviewHolder(view);
    }

    public class PostviewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemSelectedListener {
        TextView textTitleCart, textPriceCart, textIDCart,remove,textDescriptionCart;
        ImageView imageViewCart;
        String textQuantity;

        public PostviewHolder(@NonNull View itemView) {
            super(itemView);
            textTitleCart = itemView.findViewById(R.id.cart_product_name);
            textPriceCart = itemView.findViewById(R.id.cart_product_Price);
            textIDCart = itemView.findViewById(R.id.pid);
            imageViewCart = itemView.findViewById(R.id.cart_product_image);
            Qty = textQuantity;

            //dropdown
            Spinner spinner;
            String[] paths = {"Qty 1", "Qty 2", "Qty 3"};
            spinner = itemView.findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(itemView.getContext(), android.R.layout.simple_spinner_item, paths);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);

        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

            switch (position) {
                case 0:
                    Toast.makeText(itemView.getContext(), "You have changed to Qty 1", Toast.LENGTH_SHORT).show();
                    textQuantity = "1";
                    break;
                case 1:
                    Toast.makeText(itemView.getContext(), "You have changed to Qty 2", Toast.LENGTH_SHORT).show();
                    textQuantity = "2";
                    break;
                case 2:
                    Toast.makeText(itemView.getContext(), "You have changed to Qty 3", Toast.LENGTH_SHORT).show();
                    textQuantity = "3";
                    break;

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            textQuantity = "1";
        }
        //dropdown
    }


}
