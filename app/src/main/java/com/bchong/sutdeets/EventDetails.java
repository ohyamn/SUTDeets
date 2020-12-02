package com.bchong.sutdeets;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventDetails {
    public String eventTitle;
    public String eventLocation;
    public String eventDate;
    public String eventTimeStart;
    public String eventTimeEnd;
    public String eventDescription;
//    private DatabaseReference mDatabase;


    public EventDetails(String eventTitle, String eventLocation, String eventDate, String eventTimeStart, String eventTimeEnd, String eventDescription){
        this.eventTitle = eventTitle;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTimeStart = eventTimeStart;
        this.eventTimeEnd = eventTimeEnd;
        this.eventDescription = eventDescription;
    }
//    public void EventToDB (String eventTitle, String eventLocation, String eventDate, String eventTimeStart, String eventTimeEnd, String eventDescription) {
//        EventDetails event = new EventDetails(eventLocation, eventDate, eventTimeStart, eventTimeEnd, eventDescription);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        mDatabase.child("Events").child(eventTitle).setValue(event);
//
//
//    }
};


