package com.example.rajvivah.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.rajvivah.R;

public class GetFamilyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_family_info);

        //Rajput Dropdown
        AutoCompleteTextView rajput_dropdown;
        rajput_dropdown = findViewById(R.id.profile_rajput);
        String[] rajput = new String []{
                "Rajawat",
                "Bhati"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                rajput
        );
        rajput_dropdown.setAdapter(adapter);

        //Gotra Dropdown
        AutoCompleteTextView gotra_dropdown;
        gotra_dropdown = findViewById(R.id.profile_gotra);
        String[] gotra = new String []{
                "Rajawat",
                "Bhati"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                gotra
        );
        gotra_dropdown.setAdapter(adapter2);


        //Manglik Dropdown
        AutoCompleteTextView manglik_dropdown;
        manglik_dropdown = findViewById(R.id.profile_mangalik);
        String[] manglik = new String []{
                "Yes",
                "No",
                "Don't Know"
        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                manglik
        );
        manglik_dropdown.setAdapter(adapter3);

        //State Dropdown
        AutoCompleteTextView state_dropdown;
        state_dropdown = findViewById(R.id.state_dropdown);

        String[] state = new String []{
                "Rajasthan",
                "Punjab",
                "Uttar Pradesh",
                "Madhya Pradesh",
                "Haryana"
        };
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                state
        );
        state_dropdown.setAdapter(adapter4);

        //District Dropdown
        AutoCompleteTextView district_dropdown;

        district_dropdown = findViewById(R.id.district_dropdown);

        String[] district = new String []{
                "Jaipur",
                "Kota",
                "Ajmer",
                "Chittor",
                "Sikar"
        };
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                district
        );
        district_dropdown.setAdapter(adapter5);

        //Tehsil Dropdown
        AutoCompleteTextView tehsil_dropdown;

        tehsil_dropdown = findViewById(R.id.tehsil_dropdown);

        String[] tehsil = new String []{
                "Chaksu",
                "Sanganer",
                "Chomu",
                "Bassi"
        };
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(
                GetFamilyInfo.this,
                R.layout.dropdown,
                tehsil
        );
        tehsil_dropdown.setAdapter(adapter6);

        //Save Button
        Button save;
        save = (Button) findViewById(R.id.save_Button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetFamilyInfo.this, GetEducationInfo.class);
                startActivity(intent);
            }
        });
    }
}