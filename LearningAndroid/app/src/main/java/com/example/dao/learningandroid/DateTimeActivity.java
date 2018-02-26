package com.example.dao.learningandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class DateTimeActivity extends AppCompatActivity {

    TextView txtDate;
    static TextView txtTime;
    ImageButton btnDate;
    ImageButton btnTime;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    static Calendar calendar = Calendar.getInstance();

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);

            txtTime.setText(timeFormat.format(calendar.getTime()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        addControls();
        addEvents();
    }

    private void addControls() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        btnDate = (ImageButton) findViewById(R.id.btnSetDate);
        btnTime = (ImageButton) findViewById(R.id.btnSetTime);

        txtDate.setText(dateFormat.format(calendar.getTime()));
        txtTime.setText(timeFormat.format(calendar.getTime()));
    }

    private void addEvents() {
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

    public void onBtnSetDate(View view) {

        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                txtDate.setText(dateFormat.format(calendar.getTime()));
            }
        };

        DatePickerDialog dialog = new DatePickerDialog(DateTimeActivity.this, callback,
                calendar.get(Calendar.YEAR),

                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }


    public void onBtnSetTime(View view) {

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }


}