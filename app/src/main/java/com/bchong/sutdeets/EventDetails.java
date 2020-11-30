package com.bchong.sutdeets;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventDetails {
    public String eventLocation;
    public String eventDate;
    public String eventTimeStart;
    public String eventTimeEnd;
    private DatabaseReference mDatabase;


    public EventDetails(String eventLocation, String eventDate, String eventTimeStart, String eventTimeEnd){
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTimeStart = eventTimeStart;
        this.eventTimeEnd = eventTimeEnd;
    }
    public void EventToDB (String eventTitle, String eventLocation, String eventDate, String eventTimeStart, String eventTimeEnd) {
        EventDetails event = new EventDetails(eventLocation, eventDate, eventTimeStart, eventTimeEnd);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Events").child(eventTitle).setValue(event);


    }
};


