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

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {
    EditText mSignupEmail, mSignupPassword;
    Button mSignupButton;
    TextView mAlreadyUser;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mSignupEmail = findViewById(R.id.signupEmail);
        mSignupPassword = findViewById(R.id.signupPassword);
        mAlreadyUser = findViewById(R.id.alreadyUser);
        mSignupButton = findViewById(R.id.signupbutton);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mSignupEmail.getText().toString();
                String password = mSignupPassword.getText().toString();
                if (email.isEmpty()){
                    mSignupEmail.setError("Please enter your email.");
                    mSignupEmail.requestFocus();
                } else if (password.isEmpty()) {
                    mSignupPassword.setError("Please enter a password");
                    mSignupPassword.requestFocus();
                } else if (!(email.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> signup) {
                            if (!signup.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Sign up was unsuccessful, please try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Sign up successful! Please Log In.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            }
                        }
                    });

                }
            }

        });
        mAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}