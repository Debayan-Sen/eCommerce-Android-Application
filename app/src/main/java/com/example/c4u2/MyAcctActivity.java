package com.example.c4u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.paperdb.Paper;

public class MyAcctActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mNameView,mPhoneView,mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_acnt);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = user.getUid();

        mNameView = (TextView) findViewById(R.id.NameView);
        mPhoneView = (TextView)findViewById(R.id.PhoneView);
        mEmailView = (TextView) findViewById(R.id.EmailView);

        findViewById(R.id.logout_btn).setOnClickListener(this);

        Firebase firebase = new Firebase("https://c4u2ecraft.firebaseio.com/Users");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nameView = dataSnapshot.child(uid).child("nAme").getValue(String.class);
                String phoneView = dataSnapshot.child(uid).child("pHone").getValue(String.class);
                String emailView = dataSnapshot.child(uid).child("eMail").getValue(String.class);

                mNameView.setText(nameView);
                mPhoneView.setText(phoneView);
                mEmailView.setText(emailView);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.logout_btn:
                Paper.book().destroy();
                startActivity(new Intent(this,Login.class));
                break;
        }

    }


}

