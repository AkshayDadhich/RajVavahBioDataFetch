package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rajvivah.modal.Biodataregistrationmodel;
import com.example.rajvivah.modal.Loginmodel;
import com.example.rajvivah.modal.Rajputcastmodel;
import com.example.rajvivah.modal.RegistrationModel;
import com.example.rajvivah.modal.Signupresponse;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodataregistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText registeruser_id, name, fathername, mothername, grandfathername, candidate_cast, candidate_gotra, registeruser_mob, candidate_mob, candidate_mail, candidate_address, candidate_post, candidate_teh, candidate_dist, candidate_state, candidate_country, candidate_polstation, candidate_pin, candidate_name_of_fatherinlaw, candidate_cast_of_fatherinlaw, candidate_gotra_of_fatherinlaw, candidate_address_of_fatherinlaw, candidate_post_of_fatherinlaw, candidate_teh_of_fatherinlaw, candidate_polstation_of_fatherinlaw, candidate_dist_of_fatherinlaw, candidate_state_of_fatherinlaw, candidate_country_of_fatherinlaw, candidate_pin_of_fatherinlaw, candidate_name_of_nanosa, candidate_cast_of_nanihal, candidate_gotra_of_nanihal, candidate_address_of_nanihal, candidate_post_of_nanihal, candidate_teh_of_nanihal, candidate_polstation_of_nanihal, candidate_dist_of_nanihal, candidate_state_of_nanihal, candidate_country_of_nanihal, candidate_pin_of_nanihal, candidate_name_of_dadera, candidate_cast_of_dadera, candidate_gotra_of_dadera, candidate_address_of_dadera, candidate_post_of_dadera, candidate_teh_of_dadera, candidate_polstation_of_dadera, candidate_dist_of_dadera, candidate_state_of_dadera, candidate_country_of_dadera, candidate_pin_of_dadera,   tenth_board,   tenth_per,   twelth_board,   tenth_sub,   twelth_per,   gradu_uni,   gradu_sub,   gradu_per,   pg_uni,   pg_sub,   pg_per,   other_edu,   other_edu_per,   other_edu_sub,   job,   job_department,   job_from,   image,
    lasteducation,lasteducation_edu_per,lasteducation_edu_sub, dahejoth_descrip, brother, sister, married, son, daughter, marriedchild, path, gender_self, refrencename, refrencenamE_MOB;
    Button btnsubmit;
    String[] rajputcast, rajputgotra;
    List<Rajputcastmodel> rajputcastList;
    List<Rajputcastmodel> rajputgotraList;
    AppCompatSpinner spnselectcandidategotra, spnselectcandidaterajput;
    ArrayList rajputgotra_list = new ArrayList();
    ArrayAdapter rajputgotra_adapter;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodataregistration);
        getrajputCast();
        btnsubmit=findViewById(R.id.btnpost);
        name = findViewById(R.id.edname);
        fathername = findViewById(R.id.edfathername);
        mothername = findViewById(R.id.edmothername);
        candidate_mob = findViewById(R.id.edcandidate_mob);
        candidate_address = findViewById(R.id.edcandidate_address);
        candidate_post = findViewById(R.id.edcandidate_post);
        candidate_teh = findViewById(R.id.edcandidate_teh);
        candidate_dist = findViewById(R.id.edcandidate_dist);
        candidate_state = findViewById(R.id.edcandidate_state);
        lasteducation = findViewById(R.id.edlasteducation);
        lasteducation_edu_per = findViewById(R.id.edlasteducation_edu_per);
        lasteducation_edu_sub = findViewById(R.id.edlasteducation_edu_sub);
        lasteducation_edu_sub = findViewById(R.id.edlasteducation_edu_sub);
        job = findViewById(R.id.edjob);
        job_department = findViewById(R.id.edjob_department);
        spnselectcandidaterajput = findViewById(R.id.spnselectcandidaterajput);
        spnselectcandidategotra = findViewById(R.id.spnselectcandidategotra);  spnselectcandidaterajput.setOnItemSelectedListener(this);
        spnselectcandidategotra.setOnItemSelectedListener(this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                postData();
            }
        });
    }
//====================

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.spnselectcandidaterajput) {
            getrajputGotra((position + 1));
            rajputgotra_adapter = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, rajputgotra_list);
            rajputgotra_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnselectcandidategotra.setAdapter(rajputgotra_adapter);
        } else if (parent.getId() == R.id.spnselectcandidategotra) {
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void getrajputCast() {
        Call<List<Rajputcastmodel>> userList = Apiclient.getUserservice().getallCast();
        userList.enqueue(new Callback<List<Rajputcastmodel>>() {
            @Override
            public void onResponse(Call<List<Rajputcastmodel>> call, Response<List<Rajputcastmodel>> response) {
                rajputcastList = new ArrayList<>();
                rajputcastList.addAll(response.body());
                rajputcast = new String[rajputcastList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < rajputcastList.size(); i++) {
                        rajputcast[i] = rajputcastList.get(i).getRajpoottype();
                    }

                    ArrayAdapter adapter = new ArrayAdapter(BiodataregistrationActivity.this, android.R.layout.simple_list_item_1, rajputcast);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnselectcandidaterajput.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Rajputcastmodel>> call, Throwable t) {

            }
        });
    }

    public void getrajputGotra(int rid) {
        rajputgotra_list.clear();
        rajputgotra_list.add(0, "Select Gotra");
        Call<List<Rajputcastmodel>> userList = Apiclient.getUserservice().getallGotra(rid);
        userList.enqueue(new Callback<List<Rajputcastmodel>>() {
            @Override
            public void onResponse(Call<List<Rajputcastmodel>> call, Response<List<Rajputcastmodel>> response) {
                rajputcastList = new ArrayList<>();
                rajputcastList.addAll(response.body());
                rajputcast = new String[rajputcastList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < rajputcastList.size(); i++) {
                        // rajputcast[i] = rajputcastList.get(i).getEgotra();
                        rajputgotra_list.add(rajputcastList.get(i).getEgotra());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Rajputcastmodel>> call, Throwable t) {

            }
        });
    }

    private void postData() {
        dialog = ProgressDialog.show(
                BiodataregistrationActivity.this, "", "Please Wait...");
        Biodataregistrationmodel modal = new Biodataregistrationmodel(
                "43434","gfgfgfgccv","gfgfgfg","gfgfgf"
        );
        Call<Biodataregistrationmodel> call = Apiclient.getUserservice().postBiodata(modal);
        call.enqueue(new Callback<Biodataregistrationmodel>() {
            @Override
            public void onResponse(Call<Biodataregistrationmodel> call, Response<Biodataregistrationmodel> response) {
                dialog.dismiss();
                alerttwoButton("Registration Sucess " +response.code(),"Sucess !");
                Biodataregistrationmodel responseFromAPI = response.body();
            }

            @Override
            public void onFailure(Call<Biodataregistrationmodel> call, Throwable t) {
                alertsingleButton("Registration Failed ", "Check Internet !");
                dialog.dismiss();
            }
        });
    }


    private void alertsingleButton(String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(title);
        alert.show();
    }
    private void alerttwoButton(String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(BiodataregistrationActivity.this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}