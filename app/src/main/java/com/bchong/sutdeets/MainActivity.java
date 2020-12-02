package com.bchong.sutdeets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button mLogout;
    Button mAddNewEvent;
    FirebaseAuth mFireBaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_events);

        new FireBaseDatabaseHelper().readEvents(new FireBaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Events> events, List<String> keys) {
                new RecyclerView_Confg().setConfig(mRecyclerView,MainActivity.this,events,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsDeleted() {

            }

            @Override
            public void DataIsUpdated() {

            }
        });
        mLogout = findViewById(R.id.logoutButton);
        mAddNewEvent = findViewById(R.id.addNewEventButton);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
        mAddNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEvent = new Intent(MainActivity.this, AddEventActivity.class);
                startActivity(addEvent);
            }
        });
    }
}