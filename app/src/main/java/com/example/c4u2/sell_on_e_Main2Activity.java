package com.example.c4u2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class sell_on_e_Main2Activity extends AppCompatActivity {

    String id;
    EditText des,nm,pr,im;
    Button sub;
    DatabaseReference databaseRefId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_on_e__main2);

        des=(EditText)findViewById(R.id.des);
        nm=(EditText)findViewById(R.id.nm);
        pr=(EditText)findViewById(R.id.pr);
        im=(EditText)findViewById(R.id.im);
        sub=(Button) findViewById(R.id.sub);

        Spinner spinner;
        String[] paths = {"DECOR","FURNISHING","PAINTING"};
        spinner = findViewById(R.id.spinnercat);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        Spinner spinner1;
        String[] paths1 = {"BUDDHA","POTS VASES","WALL DECOR","MARBLE PAINTING","SET OF 4","AC BLANKET"};
        spinner1 = findViewById(R.id.spinnersubcat);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);

        databaseRefId = FirebaseDatabase.getInstance().getReference("PRODUCTS").child("PAINTING").child("SET OF 4");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = databaseRefId.push().getKey();
                HashMap<String,Object> map=new HashMap<>();
                map.put("DESCRIPTION",des.getText().toString().trim());
                map.put("PRICE",pr.getText().toString().trim());
                map.put("IMAGE",im.getText().toString().trim());
                map.put("NAME",nm.getText().toString().trim());
                map.put("PID",id);

                databaseRefId.child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(sell_on_e_Main2Activity.this,"com",Toast.LENGTH_LONG).show();
                        des.setText("");
                        nm.setText("");
                        im.setText("");
                        pr.setText("");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(sell_on_e_Main2Activity.this,"incom",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
