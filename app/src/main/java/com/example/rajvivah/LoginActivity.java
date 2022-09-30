package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rajvivah.modal.Loginmodel;
import com.example.rajvivah.webapi.Apiclient;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    EditText phonenum, password;
    Button login;
    Dialog dialog;
    TextView register;
    boolean isEmailValid, isPasswordValid, isallValid;
    TextInputLayout phoneerr, passError;
    List<Loginmodel> loginmodel;
    String lmessage;
    SharedPreferences sharedpreferences;
    String email, passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lmessage = "";
        isallValid = false;
        phonenum = (EditText) findViewById(R.id.phonenum);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        phoneerr = (TextInputLayout) findViewById(R.id.phoneerr);
        passError = (TextInputLayout) findViewById(R.id.passError);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    SetValidation();
                    validateLogin();
                } catch (Exception e) {

                }


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        try {

            // Check for a valid email address.
            if (phonenum.getText().toString().isEmpty()) {
                phoneerr.setError(getResources().getString(R.string.phone_error));
                isEmailValid = false;
            } else {
                isEmailValid = true;
                phoneerr.setErrorEnabled(false);
            }

            // Check for a valid password.
            if (password.getText().toString().isEmpty()) {
                passError.setError(getResources().getString(R.string.password_error));
                isPasswordValid = false;
            } else if (password.getText().length() < 6) {
                passError.setError(getResources().getString(R.string.error_invalid_password));
                isPasswordValid = false;
            } else {
                isPasswordValid = true;
                passError.setErrorEnabled(false);
            }

            if (isEmailValid && isPasswordValid) {
                //  Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
                isallValid = true;
            }

        } catch (Exception e) {
            dialog.dismiss();
        }

    }

    public void validateLogin() {

        try {

            dialog = ProgressDialog.show(
                    LoginActivity.this, "", "Please wait...");
            Call<List<Loginmodel>> userList = Apiclient.getUserservice().getuserLogin(phonenum.getText().toString(), password.getText().toString());
            userList.enqueue(new Callback<List<Loginmodel>>() {
                @Override
                public void onResponse(Call<List<Loginmodel>> call, Response<List<Loginmodel>> response) {

                    try {

                        loginmodel = new ArrayList<Loginmodel>();
                        loginmodel.addAll(response.body());
                        String[] profiledetails = new String[loginmodel.size()];
                        if (response.isSuccessful()) {
                            lmessage = loginmodel.get(0).getMessage();
                            if (isallValid && lmessage.equals("usrlogsucess")) {
                                //========================
                                SharedPreferences mPrefs = getSharedPreferences("IDvalue", Context.MODE_MULTI_PROCESS);
                                SharedPreferences.Editor editor = mPrefs.edit();
                                editor.putString("name", loginmodel.get(0).getName().toString());
                                editor.putString("regis", loginmodel.get(0).getRegisteruser_id().toString());
                                editor.commit();

                                //===========================
                                String i = loginmodel.get(0).getRegisteruser_id().toString();
                                dialog.dismiss();

                                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                                // myIntent.putExtra("firstName", i);
                                //myIntent.putExtra("lastName", "Your Last Name Here");
                                startActivity(myIntent);

                            } else if (loginmodel.get(0).getMessage().equals("Your Id Deactivated By Admin Please Contact to Admin")) {
                                dialog.dismiss();
                                alertsingleButton(lmessage);
                            } else if (loginmodel.get(0).getMessage().equals("Your Id temporary Deactivated")) {
                                dialog.dismiss();
                                alertsingleButton(lmessage);
                            } else if (loginmodel.get(0).getMessage().equals("Your ID Deleted By Your Self. Please contact to admin !")) {
                                dialog.dismiss();
                                alertsingleButton(lmessage);
                            } else if (loginmodel.get(0).getMessage().equals("Invalid User Name or Password!")) {
                                dialog.dismiss();
                                alertsingleButton(lmessage);
                            } else {
                                dialog.dismiss();
                                alertsingleButton(lmessage);
                            }
                        } else {

                        }

                    } catch (Exception e) {
                        dialog.dismiss();
                    }


                }

                @Override
                public void onFailure(Call<List<Loginmodel>> call, Throwable t) {
                    dialog.dismiss();
                }
            });
        } catch (Exception e) {
            dialog.dismiss();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (email != null && password != null) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    private void alerttwoButton(String m) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("You are not registred. Do you want\n to Register?" + m);
        builder.setTitle("Register ! ");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void alertsingleButton(String message) {
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
        alert.setTitle("Invalid Details ! ");
        alert.show();
    }
}