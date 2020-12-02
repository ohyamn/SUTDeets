package com.bchong.sutdeets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class EventConfirmation extends AppCompatActivity {
    TextView mNewEventTitle, mNewEventLocation, mNewEventTimeStart, mNewEventTimeEnd;
    TextView mConfirmEventTitle, mConfirmEventLocation, mConfirmEventDate, mConfirmEventTime, mConfirmEventDescription;
    CalendarView mNewEventDate;
    Button mCancelButton, mConfirmButton;

    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_confirmation);
        mNewEventTitle = findViewById(R.id.newEventTitle);
        mNewEventLocation = findViewById(R.id.newEventLocation);
        mNewEventDate = findViewById(R.id.newEventDate);
        mNewEventTimeStart = findViewById(R.id.newEventTimeStart);
        mNewEventTimeEnd = findViewById(R.id.newEventTimeEnd);
        mCancelButton = findViewById(R.id.cancelButton);
        mConfirmButton = findViewById(R.id.confirmButton);

        mConfirmEventTitle = findViewById(R.id.confirmEventTitle);
        mConfirmEventLocation = findViewById(R.id.confirmEventLocation);
        mConfirmEventDate = findViewById(R.id.confirmEventDate);
        mConfirmEventTime = findViewById(R.id.confirmEventTime);
        mConfirmEventDescription = findViewById(R.id.confirmEventDescription);

        final Bundle eventDetails = getIntent().getExtras();
        mConfirmEventTitle.setText("Title: " + eventDetails.getString("eventTitle"));
        mConfirmEventLocation.setText("Location: " + eventDetails.getString("eventLocation"));
        mConfirmEventDate.setText("Date: " + eventDetails.getString("eventDate"));
        mConfirmEventTime.setText("Time: " + eventDetails.getString("eventTimeStart") + " to " + eventDetails.getString("eventTimeEnd"));
        mConfirmEventDescription.setText("Description: " + eventDetails.getString("eventDescription"));

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //return to previous activity while saving state
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventDetails testPush = new EventDetails(
                        eventDetails.getString("eventTitle"),
                        eventDetails.getString("eventLocation"),
                        eventDetails.getString("eventDate"),
                        eventDetails.getString("eventTimeStart"),
                        eventDetails.getString("eventTimeEnd"),
                        eventDetails.getString("eventDescription"));
                mDatabase.child("Testing").child("Test Event").setValue(testPush);
            }
        });


    }
}
