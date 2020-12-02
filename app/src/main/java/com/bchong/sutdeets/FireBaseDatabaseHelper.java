package com.bchong.sutdeets;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//manipuplating real time database
public class FireBaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferanceEvents;
    private List<Events> events=new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Events> events,List<String> keys);
        void DataIsInserted();
        void DataIsDeleted();
        void DataIsUpdated();
    }
    public FireBaseDatabaseHelper() {
        mDatabase=FirebaseDatabase.getInstance();
        mReferanceEvents=mDatabase.getReference("Events");
    }
    public void readEvents(final DataStatus datastatus){
        List<String> keys=new ArrayList<>();
        datastatus.DataIsLoaded(events,keys);
        mReferanceEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                events.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Events event=keyNode.getValue(Events.class);
                    events.add(event);
                }
                datastatus.DataIsLoaded(events,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
