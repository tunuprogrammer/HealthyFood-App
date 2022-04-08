package com.example.healthyfoodcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    TextView signup;
    EditText email;
    EditText password;
    Button login;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password1);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        auth = FirebaseAuth.getInstance();

        //LOGIN BUTTON
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password1 = password.getText().toString();
                //loginuser(txt_email,txt_password1);

                if (txt_email.isEmpty()) {
                    email.setError(getResources().getString(R.string.email_error));
                    email.requestFocus();
                } else if (txt_password1.isEmpty()) {
                    password.setError(getResources().getString(R.string.password1_error));
                    password.requestFocus();
                } else if (txt_password1.length() < 6) {
                    password.setError(getResources().getString(R.string.passwordlength_error));
                    password.requestFocus();
                } else {
                    email.setError(null);
                    password.setError(null);
                    auth.signInWithEmailAndPassword(txt_email, txt_password1).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(login.this, Dashboard_page.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(login.this, "wrong email or password,Please Try again", Toast.LENGTH_SHORT).show();
                                  }
                        }
                    });
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(login.this,register.class);
                startActivity(i);
            }
        });
    }

}
