package com.example.c4u2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.c4u2.Model.User;
import com.example.c4u2.prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.paperdb.Paper;

public class register extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout InputName, InputMail, InputPhone, InputPassword;
    private Button mRegisterBtn;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private FirebaseDatabase firebaseDatabase;
    private DataSnapshot dataSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        InputMail = findViewById(R.id.InputMail);
        InputPassword = findViewById(R.id.InputPassword);
        mAuth = FirebaseAuth.getInstance();
        mRegisterBtn = findViewById(R.id.registerButton);
        InputName = findViewById(R.id.InputName);
        InputPhone = findViewById(R.id.InputPhone);
        firebaseDatabase = FirebaseDatabase.getInstance();


        mRegisterBtn.setOnClickListener(this);

    }

    private void registerUser(){
        final String eMail = InputMail.getEditText().getText().toString();
        String passWord = InputPassword.getEditText().getText().toString();
        final String nAme = InputName.getEditText().getText().toString();
        final String pHone = InputPhone.getEditText().getText().toString();

        Paper.book().write(Prevalent.UserEmailKey,eMail);
        Paper.book().write(Prevalent.UserPasswordKey,passWord);

        if (nAme.isEmpty()){
            InputName.setError("Please Enter your Name");
            InputName.requestFocus();
            return;
        }

        if (pHone.isEmpty()){
            InputPhone.setError("Phone Number Require");
            InputPhone.requestFocus();
            return;
        }

        if (pHone.length()!=10){
            InputPhone.setError("Please enter valid Phone number");
            InputPhone.requestFocus();
            return;
        }

        if (eMail.isEmpty()){
            InputMail.setError("E-mail is required");
            InputMail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(eMail).matches()){
            InputMail.setError("Please Enter a valid Email");
            InputMail.requestFocus();
            return;
        }

        if (passWord.isEmpty()){
            InputPassword.setError("Password is required");
            InputPassword.requestFocus();
            return;
        }

        if (passWord.length()<6){
            InputPassword.setError("Minimum Length of Password should be 6");
            InputPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(eMail,passWord).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){

                    User user = new User(nAme,eMail,pHone);

                    firebaseDatabase.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            //problem
                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                //User userdata = dataSnapshot.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(User.class);
                                Intent intent = new Intent(register.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }else {
                                Toast.makeText(register.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                            }
                            //problem
                        }
                    });

                }else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"Email already Registered",Toast.LENGTH_SHORT).show();
                        InputMail.setError("Try using another E-mail");
                        InputMail.requestFocus();
                    }else{
                        Toast.makeText(register.this, "Some Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.registerButton) {
            registerUser();
        }
    }
}
