package com.example.rajvivah.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.rajvivah.DisplayCardView;
import com.example.rajvivah.R;

public class GetEducationInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_education_info);

        //Qualification Dropdown
        AutoCompleteTextView graduation_dropdown;

        graduation_dropdown = findViewById(R.id.profile_highest_qualification);

        String[] qualification = new String []{
                "MTech",
                "BTech",
                "MBA",
                "MA",
                "BA"
        };
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(
                GetEducationInfo.this,
                R.layout.dropdown,
                qualification
        );
        graduation_dropdown.setAdapter(adapter6);

        //Profession Dropdown
        AutoCompleteTextView profession_dropdown;

        profession_dropdown = findViewById(R.id.profile_profession);

        String[] profession = new String []{
                "Government Job(State)",
                "Government Job(Center/PSU)",
                "Business",
                "Staff with private company",
                "Contractual in Government",
                "Contractor in Government",
                "Others"
        };
        ArrayAdapter<String> adapter7 = new ArrayAdapter<>(
                GetEducationInfo.this,
                R.layout.dropdown,
                profession
        );
        profession_dropdown.setAdapter(adapter7);

        //Annual Income Dropdown
        AutoCompleteTextView annual_income_dropdown;

        annual_income_dropdown = findViewById(R.id.profile_annual_income);

        String[] annual_income = new String []{
                "Below 2.5 Lakh",
                "Between 2.5 Lakh to 5 Lakh",
                "Between 5 Lakh to 7 Lakh",
                "Between 7 Lakh to 10 Lakh",
                "Between 10 Lakh to 15 Lakh",
                "Above 15 Lakh",
                "I don't want to disclose",
                "No income"
        };
        ArrayAdapter<String> adapter8 = new ArrayAdapter<>(
                GetEducationInfo.this,
                R.layout.dropdown,
                annual_income
        );
        annual_income_dropdown.setAdapter(adapter8);


        //Save Button
        Button save1;
        save1 = findViewById(R.id.save_Button1);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetEducationInfo.this, DisplayCardView.class);
                startActivity(intent);
            }
        });

    }
}