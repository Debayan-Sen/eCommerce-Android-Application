package com.example.c4u2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.c4u2.Model.Products;
import com.example.c4u2.prevalent.Adapters;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProductRecycleView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapters adapters;
    FirebaseRecyclerOptions<Products> options;
    TextView screenTitle;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_recycle_view);

       screenTitle = findViewById(R.id.screenTitle);

       recyclerView = findViewById(R.id.recyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       getValueToFind();

       adapters = new Adapters(options);


       recyclerView.setAdapter(adapters);
    }

    private void getValueToFind() {
       switch (getIntent().getIntExtra("swValue",0)){
           //home
           case 1:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("DECOR").child("POT & VASES"),Products.class).build();
               screenTitle.setText("ECrafts DESIGNER POT & VASES");
               break;
           case 2:
               //furnishing
               //decor
           case 21:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("DECOR").child("BUDDHA"),Products.class).build();
               screenTitle.setText("ECrafts Lord Buddha");
               break;
           case 3:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FURNISHING").child("WALL DECOR"),Products.class).build();
               screenTitle.setText("ECrafts WALL DECOR");
               break;
           case 43:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("PAINTING").child("MARBLE PAINTING"),Products.class).build();
               screenTitle.setText("ECrafts Marble Paintings");
               break;
           case 4:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("PAINTING").child("SET OF 4"),Products.class).build();
               screenTitle.setText("ECrafts SET OF 4PAINTINGS");
               break;
           case 32:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FURNISHING").child("AC BLANKET"),Products.class).build();
               screenTitle.setText("ECrafts AC Blankets");
               break;
           case 11:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FOR GIFTS"),Products.class).build();
               screenTitle.setText("ECrafts GIFTS FOR SPECIAL DAY");
               break;
           case 12:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("IN OFFERS"),Products.class).build();
               screenTitle.setText("SPECIAL OFFER FOR THE DAY");
               break;
           case 13:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("KIDS"),Products.class).build();
               screenTitle.setText("ECrafts KIDS' SPECIAL");
               break;
               //home
           //paint
           case 41:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("PAINTING").child("SET OF 4"),Products.class).build();
               screenTitle.setText("ECrafts SET OF 4 Paintings");
               break;
           case 42:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("PAINTING").child("SET OF 3"),Products.class).build();
               screenTitle.setText("ECrafts SET OF 3 Paintings");
               break;
           case 44:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("PAINTING").child("SILK PAINTING"),Products.class).build();
               screenTitle.setText("ECrafts SILK PAINTINGS");
               break;
               //paint
           //furnishing
           case 31:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FURNISHING").child("CLOCK"),Products.class).build();
               screenTitle.setText("ECrafts DESIGNER CLOCK HANDMAID");
               break;
           case 33:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FURNISHING").child("TRAY"),Products.class).build();
               screenTitle.setText("ECrafts KITCHEN ESSENTIALS");
               break;
           case 34:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("FURNISHING").child("TRAY"),Products.class).build();
               screenTitle.setText("Rajasthani QUILTS by ECrafts");
               break;
               //furnishing
           //decor
           case 22:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("DECOR").child("BRASS"),Products.class).build();
               screenTitle.setText("ECrafts LATEST BRASS ITEMS");
               break;
           case 23:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("DECOR").child("GANESHA"),Products.class).build();
               screenTitle.setText("ECrafts LORD GANESHA");
               break;
           case 24:
               options = new FirebaseRecyclerOptions.Builder<Products>().setQuery(FirebaseDatabase.getInstance().getReference().child("PRODUCTS").child("DECOR").child("KRISHNA"),Products.class).build();
               screenTitle.setText("ECrafts LORD KRISHNA");
               break;
               //decor
       }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapters.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapters.startListening();
    }
}
