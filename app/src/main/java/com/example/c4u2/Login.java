package com.example.c4u2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.c4u2.prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout InputMail, InputPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        InputMail = findViewById(R.id.InputMail);
        InputPassword = findViewById(R.id.InputPassword);
        mAuth = FirebaseAuth.getInstance();

        Paper.init(this);

        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.buttonLogin).setOnClickListener(this);

    }



    public void userLogin(){
        String eMail = InputMail.getEditText().getText().toString();
        String passWord = InputPassword.getEditText().getText().toString();

        Paper.book().write(Prevalent.UserEmailKey,eMail);
        Paper.book().write(Prevalent.UserPasswordKey,passWord);

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

        mAuth.signInWithEmailAndPassword(eMail,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(Login.this,MainActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    Paper.book().destroy();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button5:
                startActivity(new Intent(this,register.class));
                break;

            case R.id.buttonLogin:
                userLogin();
                break;


        }
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            moveTaskToBack(true);
        } else {
            backToast = Toast.makeText(this,"Press Back Again to Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
