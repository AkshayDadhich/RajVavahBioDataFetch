package com.example.rajvivah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.rajvivah.modal.RegistrationModel;
import com.example.rajvivah.webapi.Apiclient;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<RegistrationModel> registrationModelList;
    BottomNavigationView bottomNavigationView;
    TextView tv_username;
    String regid="",names="";
    ImageButton logOutB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //===============================
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",MODE_PRIVATE);
        names= mPrefs.getString("name", "");
        regid = mPrefs.getString("regis", "");
        /*logOutB=findViewById(R.id.logOutB);*/

       // Toast.makeText(MainActivity.this, "Main activity :-  " +regid+names, Toast.LENGTH_SHORT).show();

        //==============================
        //  tv_username=findViewById(R.id.candidate_username);
        tv_username = (TextView) findViewById(R.id.candidate_username);
        getSupportActionBar().hide();
        //Fragment Part start here
        getuserprofileDetails();

      /*  logOutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertMessage("Logout Button","You Clicked on it");
            }
        });*/

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.nav_profile) {
                    loadFragment(new ProfileFragment(), false);

                } else if (id == R.id.nav_matches) {
                    loadFragment(new MatchesFragment(), false);
                } else if (id == R.id.nav_chat) {
                    loadFragment(new ChatFragment(), false);
                } else if (id == R.id.nav_notifications) {
                    loadFragment(new NotificationsFragment(), false);
                } else
                    loadFragment(new MatchesFragment(), true);


                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_matches);

    }


    public void loadFragment(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag)
            fragmentTransaction.add(R.id.container, fragment);
        else
            fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void getuserprofileDetails() {
        Call<List<RegistrationModel>> userList = Apiclient.getUserservice().getuserProfile(regid);
        userList.enqueue(new Callback<List<RegistrationModel>>() {
            @Override
            public void onResponse(Call<List<RegistrationModel>> call, Response<List<RegistrationModel>> response) {
                registrationModelList = new ArrayList<>();
                registrationModelList.addAll(response.body());
                // String[] profiledetails = new String[registrationModelList.size()];
                if (response.isSuccessful()) {
                    for (int i = 0; i < registrationModelList.size(); i++) {
                        //       profiledetails[i] = (i+1) +"  " +registrationModelList.get(i).getName();
                        //MainActivity.this.tv_username.setText(registrationModelList.get(i).getName().toString());
                        //  Toast.makeText(MainActivity.this, "Main activity :-  " +registrationModelList.get(i).getName().toString(), Toast.LENGTH_SHORT).show();

                    }

                   // Log.e("sucesspppp", response.body().toString());
                    // Toast.makeText(Registeroffence.this, "Data " +response.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    // Toast.makeText(MainActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RegistrationModel>> call, Throwable t) {
            }
        });
    }
    private void alertMessage(String altitle, String almessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        builder.setMessage(almessage)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(altitle);
        alert.show();
    }


}