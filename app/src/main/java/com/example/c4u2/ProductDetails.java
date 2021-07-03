package com.example.c4u2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4u2.Model.User;
import com.example.c4u2.prevalent.Prevalent;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProductDetails extends AppCompatActivity implements View.OnClickListener {

    String imagePrice,imageTitle,imageDescription,imageView,pId;
    TextView productCost,productName,productDescription,cartTextView,buyTextView,pid;
    ImageView productDisplay;
    EditText emailc;
    User currentUser;
    DatabaseReference dataref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        emailc=findViewById(R.id.emailc);


        cartTextView = findViewById(R.id.cartTextView);
        cartTextView.setOnClickListener(this);
        buyTextView = findViewById(R.id.buyTextView);
        buyTextView.setOnClickListener(this);



         imagePrice = getIntent().getStringExtra("PPrice");
        productCost = findViewById(R.id.productCost);
        productCost.setText(imagePrice);

         imageTitle = getIntent().getStringExtra("PName");
        productName = findViewById(R.id.productName);
        productName.setText(imageTitle);

         imageDescription = getIntent().getStringExtra("PDescription");
        productDescription = findViewById(R.id.productDescription);
        productDescription.setText(imageDescription);

        imageView = getIntent().getStringExtra("PImage");
        productDisplay = findViewById(R.id.productDisplay);
        Picasso.get().load(imageView).into(productDisplay);

        pId = getIntent().getStringExtra("PID");
        pid = findViewById(R.id.pid);
        pid.setText(pId);




        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        dataref= FirebaseDatabase.getInstance().getReference().child("Users");
        dataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String  phoneView = snapshot.child(uid).child("pHone").getValue(String.class);
                //Toast.makeText(ProductDetails.this,"com" + emailView ,Toast.LENGTH_LONG).show();
                emailc.setText(phoneView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cartTextView:
                String c = emailc.getText().toString();
                //Toast.makeText(ProductDetails.this,"yuiyuyuiyiuyuiyiuuiohju "+c,Toast.LENGTH_LONG).show();
                HashMap<String,Object> map=new HashMap<>();
                map.put("PName",imageTitle);
                map.put("PPrice",imagePrice);
                map.put("PDescription",imageDescription);
                map.put("PImage",imageView);
                map.put("PID",pId);


                //  String c=emailc.getText().


                FirebaseDatabase.getInstance().getReference().child("CART LIST").child(c).child(pId).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ProductDetails.this,"Added to Cart",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProductDetails.this,"incom",Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.buyTextView:
                //Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProductDetails.this,confirmOrder.class);
                intent.putExtra("PID",pId);
                startActivity(intent);

        }
    }


}
