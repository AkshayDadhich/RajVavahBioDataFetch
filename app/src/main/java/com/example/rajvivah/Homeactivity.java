package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Homeactivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView gender_dropdown;
    TextView dobTextView;
    Button dobBtn;
    TextView birthTime;
    Button birthtime_button;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        textInputLayout = findViewById(R.id.profile_gender);
        gender_dropdown = findViewById(R.id.gender_dropdown);

        //Gender Dropdown
        String[] gender = new String[]{
                "Male",
                "Female"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                Homeactivity.this,
                R.layout.dropdown,
                gender
        );
        gender_dropdown.setAdapter(adapter);


        //Save Button
        save = (Button) findViewById(R.id.save_Button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homeactivity.this, BiodataregistrationActivity.class);
                startActivity(intent);
            }
        });

//      Date Picker
        dobTextView = findViewById(R.id.profile_dob);
        dobBtn = findViewById(R.id.dob_button);
        dobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Homeactivity.this, Homeactivity.this, year, month, day);
                datePickerDialog.show();
            }
        });
//      Time Picker
        birthTime = findViewById(R.id.profile_birthtime);
        birthtime_button = findViewById(R.id.birthtime_button);
        birthtime_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR);
                minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(Homeactivity.this, Homeactivity.this, hour, minute,true);
                timePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = day;
        myMonth = month;
        dobTextView.setText("Year: " + myYear +
                " Month: " + myMonth +
                " Day: " + myday );

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        birthTime.setText("Hour: " + myHour +
                " Minute: " + myMinute);
    }
}