package com.bchong.sutdeets;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    EditText mLoginEmail, mLoginPassword;
    Button mLoginButton;
    TextView mNotUser;
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mLoginEmail = findViewById(R.id.loginEmail);
        mLoginPassword = findViewById(R.id.loginPassword);
        mLoginButton = findViewById(R.id.loginButton);
        mNotUser = findViewById(R.id.notUser);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Please log in.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mLoginEmail.getText().toString();
                String password = mLoginPassword.getText().toString();
                if (email.isEmpty()){
                    mLoginEmail.setError("Please enter your email.");
                    mLoginEmail.requestFocus();
                } else if (password.isEmpty()) {
                    mLoginPassword.setError("Please enter a password");
                    mLoginPassword.requestFocus();
                } else {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> login) {
                            if (login.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "You're logged in", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "SADKEK", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
        mNotUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(toSignup);
            }
        });
    }
//

}