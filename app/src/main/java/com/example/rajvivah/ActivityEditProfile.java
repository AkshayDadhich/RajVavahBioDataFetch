package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rajvivah.modal.RegistrationModel;
import com.example.rajvivah.uservice.vivahAPIGetRegistration;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityEditProfile extends AppCompatActivity {
    EditText et_userName1,et_father_name,et_mobile, et_mother_name, et_cast, et_gotra,
            et_address, et_village, et_city, ev_candidate_district,et_pincode, et_state;
    TextView tv_usernameEdit, tv_EditPersonalInfo, tv_CastInfo, tv_EditAddress;
    List<RegistrationModel> registrationModelList;
    String regid="",names="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        //===============================
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",MODE_PRIVATE);
        names= mPrefs.getString("name", "");
        regid = mPrefs.getString("regis", "");

        //==============================

        et_userName1 = findViewById(R.id.et_userName1);
        et_father_name = findViewById(R.id.et_father_name);
        et_mobile = findViewById(R.id.et_mobile);
        et_mother_name = findViewById(R.id.et_mother_name);
        et_cast = findViewById(R.id.et_cast);
        et_gotra = findViewById(R.id.et_gotra);
        et_address = findViewById(R.id.et_address);
        et_village = findViewById(R.id.et_village);
        et_city = findViewById(R.id.et_city);
        ev_candidate_district=findViewById(R.id.evviewcandidatedistrict);
        et_pincode = findViewById(R.id.et_pincode);
        et_state = findViewById(R.id.et_state);

        tv_usernameEdit = findViewById(R.id.tv_usernameEdit);
        tv_EditPersonalInfo = findViewById(R.id.tv_EditPersonalInfo);
        tv_CastInfo = findViewById(R.id.tv_CastInfo);
        tv_EditAddress = findViewById(R.id.tv_EditAddress);

        et_userName1.setFocusable(false);
        et_father_name.setFocusable(false);
        et_mobile.setFocusable(false);
        et_mother_name.setFocusable(false);
        et_cast.setFocusable(false);
        et_gotra.setFocusable(false);
        et_address.setFocusable(false);
        et_village.setFocusable(false);
        et_city.setFocusable(false);
        et_pincode.setFocusable(false);
        et_state.setFocusable(false);
        getuserprofileDetails();
        tv_usernameEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_userName1.setFocusable(true);
            }
        });
        tv_EditPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_father_name.setFocusable(true);
                et_mobile.setFocusable(true);
                et_mother_name.setFocusable(true);
            }
        });
        tv_CastInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_cast.setFocusable(true);
                et_gotra.setFocusable(true);
            }
        });
        tv_EditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_address.setFocusable(true);
                et_village.setFocusable(true);
                et_city.setFocusable(true);
                et_pincode.setFocusable(true);
                et_state.setFocusable(true);
            }
        });
    }

    public void getuserprofileDetails() {
        Call<List<RegistrationModel>> userList = Apiclient.getUserservice().getuserProfile(regid.toString());
        userList.enqueue(new Callback<List<RegistrationModel>>() {
            @Override
            public void onResponse(Call<List<RegistrationModel>> call, Response<List<RegistrationModel>> response) {
                registrationModelList = new ArrayList<>();
                registrationModelList.addAll(response.body());
               // String[] profiledetails = new String[registrationModelList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < registrationModelList.size(); i++) {
                 //       profiledetails[i] = (i+1) +"  " +registrationModelList.get(i).getName();
                        et_userName1.setText(registrationModelList.get(i).getName());
                        et_father_name.setText(registrationModelList.get(i).getFathername());
                        et_mobile.setText(registrationModelList.get(i).getRegisteruser_mob());
                        et_mother_name.setText(registrationModelList.get(i).getMothername());
                        et_cast.setText(registrationModelList.get(i).getCandidate_cast());
                        et_gotra.setText(registrationModelList.get(i).getCandidate_gotra());
                        et_address.setText(registrationModelList.get(i).getCandidate_address());
                        et_village.setText(registrationModelList.get(i).getCandidate_address());
                        et_city.setText(registrationModelList.get(i).getCandidate_teh());
                        ev_candidate_district.setText(registrationModelList.get(i).getCandidate_dist());
                        et_state.setText(registrationModelList.get(i).getCandidate_state());
                        et_pincode.setText(registrationModelList.get(i).getCandidate_pin());
                      //  Toast.makeText(ActivityEditProfile.this, "Data " +registrationModelList.get(i).getName().toString(), Toast.LENGTH_SHORT).show();

                    }

                    Log.e("sucesspppp", response.body().toString());
                    // Toast.makeText(Registeroffence.this, "Data " +response.toString(), Toast.LENGTH_SHORT).show();
                } else {
                   // Toast.makeText(ActivityEditProfile.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<RegistrationModel>> call, Throwable t) {
            }
        });
    }

}