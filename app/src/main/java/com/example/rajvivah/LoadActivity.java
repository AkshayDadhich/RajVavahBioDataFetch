package com.example.rajvivah;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rajvivah.modal.Responseversioncheck;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadActivity extends AppCompatActivity {
    List<Responseversioncheck> profileList;
    String latestverion, runningviononapp;
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        getSupportActionBar().hide();
        runningviononapp = getString(R.string.app_runningversion);
        checkapplatestVersion();
        Intent mainIntent = null;       
        mainIntent = new Intent(LoadActivity.this, BiodatafetchActivity.class);
        startActivity(mainIntent);
        finish();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                try {

                    Intent mainIntent = null;
                    SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                    Boolean check = preferences.getBoolean("flag", false);
                    if (latestverion.equals(runningviononapp)) {
                        if (check) {
                            // registration activity
                            mainIntent = new Intent(LoadActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            //loing activity
                            mainIntent = new Intent(LoadActivity.this, LoginActivity.class);
                            startActivity(mainIntent);
                            finish();
                        }
                    } else {
                        alertMessage("Update Warning !", "Please update your app.");
                    }
                }
                catch(Exception e){
                    alertMessage("Internet Issue !", "Please Check Internet !");
                }


                //-----------------------
            }


        }, SPLASH_DISPLAY_LENGTH);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                try {

                    Intent mainIntent = null;
                    SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                    Boolean check = preferences.getBoolean("flag", false);
                    if (latestverion.equals(runningviononapp)) {
                        if (check) {
                            // registration activity
                            mainIntent = new Intent(LoadActivity.this, LoginActivity.class);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            //loing activity
                            mainIntent = new Intent(LoadActivity.this, LoginActivity.class);
                            startActivity(mainIntent);
                            finish();
                        }
                    } else {
                        alertMessage("Update Warning !", "Please update your app.");
                    }

                }
                catch(Exception e){
                    alertMessage("Internet Issue !", "Please Check Internet !");
                }


            }


        }, SPLASH_DISPLAY_LENGTH);
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

    public void checkapplatestVersion() {

        try {
            Call<List<Responseversioncheck>> userList = Apiclient.getUserservice().checkapplatestVersion("1.0");

            userList.enqueue(new Callback<List<Responseversioncheck>>() {
                @Override
                public void onResponse(Call<List<Responseversioncheck>> call, Response<List<Responseversioncheck>> response) {
                    try {
                        profileList = new ArrayList<>();
                        profileList.addAll(response.body());
                        if (response.isSuccessful()) {
                            for (int i = 0; i < profileList.size(); i++) {
                                latestverion = profileList.get(i).getAppversionondevice();
                                if (latestverion.equals(runningviononapp)) {
                                    break;
                                }
                            }
                        } else {
                            alertMessage("not !", "Please check mobile data !");
                        }
                    } catch (Exception e) {

                    }


                }

                @Override
                public void onFailure(Call<List<Responseversioncheck>> call, Throwable t) {
                }
            });
        } catch (Exception e) {

        }


    }


}