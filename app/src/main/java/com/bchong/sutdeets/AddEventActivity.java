package com.bchong.sutdeets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEventActivity extends AppCompatActivity {

    EditText mNewEventTitle, mNewEventLocation, mNewEventDescription;
    TextView mNewEventTimeStart, mNewEventTimeEnd;
    CalendarView mNewEventDate;
    Button mCreateEventButton;
    int eventHour, eventMinute;
    JSONArray eventDetails = new JSONArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mNewEventTitle = findViewById(R.id.newEventTitle);
        mNewEventLocation = findViewById(R.id.newEventLocation);
        mNewEventTimeStart = findViewById(R.id.newEventTimeStart);
        mNewEventTimeEnd = findViewById(R.id.newEventTimeEnd);
        mNewEventDate = findViewById(R.id.newEventDate);
        mNewEventDescription = findViewById(R.id.newEventDescription);
        mCreateEventButton = findViewById(R.id.createEventButton);

        final Calendar calendar = Calendar.getInstance();
        final String[] finalfinalDate = new String[1];

        mNewEventTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddEventActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                eventHour = hourOfDay;
                                eventMinute = minute;
                                String time = eventHour + ":" + eventMinute;
                                SimpleDateFormat eventTime24Hrs = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = eventTime24Hrs.parse(time);
                                    SimpleDateFormat eventTime12Hrs = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    mNewEventTimeStart.setText(eventTime12Hrs.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, 12, 0, false
                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(eventHour,eventMinute);
                timePickerDialog.show();
            }
        });

        mNewEventTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddEventActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                eventHour = hourOfDay;
                                eventMinute = minute;
                                String time = eventHour + ":" + eventMinute;
                                SimpleDateFormat eventTime24Hrs = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = eventTime24Hrs.parse(time);
                                    SimpleDateFormat eventTime12Hrs = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    mNewEventTimeEnd.setText(eventTime12Hrs.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, 12, 0, false
                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(eventHour,eventMinute);
                timePickerDialog.show();
            }
        });

        mNewEventDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
                String dateTime = sdf.format(calendar.getTime());
                finalfinalDate[0] = dateTime;
                Toast.makeText(AddEventActivity.this, "Date selected:" + dateTime, Toast.LENGTH_SHORT).show();
            }
        });


//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
//        long dateToBeAdded =
//        final String dateString = sdf.format(mNewEventDate);


        mCreateEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddEventActivity.this, "Double Check...", Toast.LENGTH_SHORT).show();
                Intent eventConfirmation = new Intent(AddEventActivity.this, EventConfirmation.class);
                eventConfirmation.putExtra("eventTitle", mNewEventTitle.getText().toString());
                eventConfirmation.putExtra("eventLocation", mNewEventLocation.getText().toString());
                eventConfirmation.putExtra("eventDate", finalfinalDate[0]);
                eventConfirmation.putExtra("eventTimeStart", mNewEventTimeStart.getText().toString());
                eventConfirmation.putExtra("eventTimeEnd", mNewEventTimeEnd.getText().toString());
                eventConfirmation.putExtra("eventDescription", mNewEventDescription.getText().toString());
                startActivity(eventConfirmation);
            }
        });
    }
}