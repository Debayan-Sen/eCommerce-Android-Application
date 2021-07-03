package com.example.c4u2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class confirmOrder extends AppCompatActivity {

    private String nameView,phoneView,emailView,Pid;
    private TextView mNameView,mPhoneView,mEmailView,getad;
    DatabaseReference databaseRef;
    Button confirm;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView,sud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        sud = findViewById(R.id.sud);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        mNameView = findViewById(R.id.cnm);
        mPhoneView = findViewById(R.id.cph);
        mEmailView = findViewById(R.id.cmail);
        getad = findViewById(R.id.cad);

        Firebase firebase = new Firebase("https://c4u2ecraft.firebaseio.com/Users");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 nameView = dataSnapshot.child(uid).child("nAme").getValue(String.class);
                 phoneView = dataSnapshot.child(uid).child("pHone").getValue(String.class);
                 emailView = dataSnapshot.child(uid).child("eMail").getValue(String.class);

                mNameView.setText(nameView);
                mPhoneView.setText(phoneView);
                mEmailView.setText(emailView);
                sud.setVisibility(View.VISIBLE);


                Pid = getIntent().getStringExtra("PID");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        //databaseRef = FirebaseDatabase.getInstance().getReference("ORDERS").child(phoneView).child(Pid);
        confirm = findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mNameView.getText().toString().trim().isEmpty()){
                    mNameView.setError("Please Enter Billing Name");
                    mNameView.requestFocus();
                    return;
                }
                if (mPhoneView.getText().toString().trim().isEmpty()){
                    mPhoneView.setError("Please Enter Billing Phone");
                    mPhoneView.requestFocus();
                    return;
                }
                if (mEmailView.getText().toString().trim().isEmpty()){
                    mEmailView.setError("Please Enter Billing mail");
                    mEmailView.requestFocus();
                    return;
                }
                if (getad.getText().toString().trim().isEmpty()){
                    getad.setError("Please Enter Billing Address");
                    getad.requestFocus();
                    return;
                }
                if (radioButton.getText().toString().isEmpty()){
                    Toast.makeText(confirmOrder.this, "Please Select a payment option", Toast.LENGTH_SHORT).show();
                    radioGroup.requestFocus();
                    return;
                }


                databaseRef = FirebaseDatabase.getInstance().getReference("ORDERS").child(phoneView).child(Pid);
                HashMap<String,Object> map=new HashMap<>();
                map.put("C_NAME",mNameView.getText().toString().trim());
                map.put("C_PHONE",mPhoneView.getText().toString().trim());
                map.put("C_EMAIL",mEmailView.getText().toString().trim());
                map.put("C_ADDRESS",getad.getText().toString().trim());
                map.put("P_ID",Pid);
                map.put("PAYMENT_METHOD",radioButton.getText());

                databaseRef.setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //Toast.makeText(confirmOrder.this,"com",Toast.LENGTH_LONG).show();
                        mNameView.setText("");
                        mEmailView.setText("");
                        mPhoneView.setText("");
                        getad.setText("");
                        Toast.makeText(confirmOrder.this, "Ordered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(confirmOrder.this,MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(confirmOrder.this,"incom",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        textView.setVisibility(View.VISIBLE);
        textView.setText(radioButton.getText()+" payment is applied");
        sud.setVisibility(View.GONE);

    }
}
