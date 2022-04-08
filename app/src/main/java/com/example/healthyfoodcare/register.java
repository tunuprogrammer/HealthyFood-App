package com.example.healthyfoodcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity
{
    EditText name;
    EditText email;
    EditText password1;
    EditText password2;
    EditText phonenumber;
    Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
        phonenumber = findViewById(R.id.phn);
        register = findViewById(R.id.register);

        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String txt_name = name.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password1 = password1.getText().toString();
                String txt_password2 = password2.getText().toString();
                String txt_phone = phonenumber.getText().toString();

                if(txt_name.isEmpty()){
                    name.setError(getResources().getString(R.string.name_error));
                    name.requestFocus();
                }
                else if(txt_name.length() <3){
                    name.setError(getResources().getString(R.string.namelength_error));
                    name.requestFocus();
                }
                else if(txt_email.isEmpty()){
                    email.setError(getResources().getString(R.string.email_error));
                    email.requestFocus();
                }
                else if(txt_phone.isEmpty()){
                    phonenumber.setError(getResources().getString(R.string.phone_error));
                    phonenumber.requestFocus();
                }
                else if(txt_phone.length() <10){
                    phonenumber.setError(getResources().getString(R.string.phnlength_error));
                    phonenumber.requestFocus();}

                else if(txt_password1.isEmpty()){
                    password1.setError(getResources().getString(R.string.password1_error));
                    password1.requestFocus();
                }
                else if(txt_password2.isEmpty()){
                    password2.setError(getResources().getString(R.string.password2_error));
                    password2.requestFocus();
                }
                else if (txt_password1.length() < 6 ) {
                    password1.setError(getResources().getString(R.string. passwordlength_error));
                    password1.requestFocus();
                }

                else if (!txt_password1.equals(txt_password2))
                {
                    password2.setError(getResources().getString(R.string.passmatch));
                    password2.requestFocus();
                }
                else
                    {
                    phonenumber.setError(null);
                    name.setError(null);
                    email.setError(null);
                    password1.setError(null);
                    password2.setError(null);
                    registeruser(txt_email,txt_password1);
                }
            }
        });
    }
    private void registeruser(String email, String password1)
    {
        auth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(register.this,"registered successful",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(register.this,login.class);
                    startActivity(i);
                    finish();
                }else
                {
                    Toast.makeText(register.this,"registration failed!Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
