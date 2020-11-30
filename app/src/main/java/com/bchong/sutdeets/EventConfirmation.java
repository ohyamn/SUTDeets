package com.bchong.sutdeets;

import androidx.appcompat.app.AppCompatActivity;

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
    TextView mConfirmEventTitle, mConfirmEventLocation, mConfirmEventDate, mConfirmEventTime;
    CalendarView mNewEventDate;
    Button mCancelButton, mConfirmButton;

//    private DatabaseReference mDatabase;


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


//        mConfirmEventTitle = findViewById(R.id.confirmEventTitle);
//        mConfirmEventTitle.setText(mNewEventTitle.getText().toString());
//
//        mConfirmEventLocation = findViewById(R.id.confirmEventLocation);
//        mConfirmEventLocation.setText(mNewEventLocation.getText().toString());
//
////        mConfirmEventDate = findViewById(R.id.confirmEventDate);
////        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
////        String dateString = sdf.format(mNewEventDate.getDate());
////        mConfirmEventDate.setText(dateString);
//
//        mConfirmEventTime = findViewById(R.id.confirmEventTime);
//        mConfirmEventTime.setText("hello world");


//        mDatabase = FirebaseDatabase.getInstance().getReference();

//        final EventDetails event = new EventDetails(
//                mNewEventLocation.toString(),
//                mNewEventDate.toString(),
//                mNewEventTimeStart.toString(),
//                mNewEventTimeEnd.toString());
//
//        mConfirmButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                event.EventToDB(
//                        mNewEventTitle.toString(),
//                        mNewEventLocation.toString(),
//                        mNewEventDate.toString(),
//                        mNewEventTimeStart.toString(),
//                        mNewEventTimeEnd.toString());
//            }
//        });


    }
}
