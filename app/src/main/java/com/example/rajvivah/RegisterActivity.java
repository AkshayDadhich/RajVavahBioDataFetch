package com.example.rajvivah;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Patterns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rajvivah.modal.Loginmodel;
import com.example.rajvivah.modal.Signuprequest;
import com.example.rajvivah.modal.Signupresponse;
import com.example.rajvivah.uservice.Apimethods;
import com.example.rajvivah.webapi.Apiclient;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, phone, password;
    Button register;
    TextView login;
    boolean isNameValid, isEmailValid, isPhoneValid, isPasswordValid;
    TextInputLayout nameError, emailError, phoneError, passError;
    Dialog dialog;
    String lmessage;
    List<Loginmodel> loginmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        nameError = (TextInputLayout) findViewById(R.id.nameError);
        emailError = (TextInputLayout) findViewById(R.id.emailError);
        phoneError = (TextInputLayout) findViewById(R.id.phoneError);
        passError = (TextInputLayout) findViewById(R.id.passError);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to LoginActivity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid name.
        if (name.getText().toString().isEmpty()) {
            nameError.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else {
            isNameValid = true;
            nameError.setErrorEnabled(false);
        }

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phoneError.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else {
            isPhoneValid = true;
            phoneError.setErrorEnabled(false);
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

        if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {
            postData();
            // Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }

//================Post Data BY Vijendra=====================

    private void postData() {
        dialog = ProgressDialog.show(
                RegisterActivity.this, "", "Please Wait...");
        Signupresponse modal = new Signupresponse(name.getText().toString(), "", phone.getText().toString(),
                email.getText().toString(), phone.getText().toString(), password.getText().toString(),
                ":1", "", "", "6",
                "True", "False", "False"
                , "1"
        );
        Call<Signupresponse> call = Apiclient.getUserservice().createPost(modal);
        call.enqueue(new Callback<Signupresponse>() {
            @Override
            public void onResponse(Call<Signupresponse> call, Response<Signupresponse> response) {
                dialog.dismiss();
                alerttwoButton("Registration Sucess ! \n You want to Login ? ", "Registration !");
                Signupresponse responseFromAPI = response.body();
            }

            @Override
            public void onFailure(Call<Signupresponse> call, Throwable t) {
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
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            validateLogin();
        });
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void validateLogin() {
        Call<List<Loginmodel>> userList = Apiclient.getUserservice().getuserLogin(phone.getText().toString(), password.getText().toString());
        userList.enqueue(new Callback<List<Loginmodel>>() {
            @Override
            public void onResponse(Call<List<Loginmodel>> call, Response<List<Loginmodel>> response) {
                loginmodel = new ArrayList<Loginmodel>();
                loginmodel.addAll(response.body());
                String[] profiledetails = new String[loginmodel.size()];
                if (response.isSuccessful()) {
                    lmessage = loginmodel.get(0).getMessage();

                    //========================
                    SharedPreferences mPrefs = getSharedPreferences("IDvalue", Context.MODE_MULTI_PROCESS);
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString("name", loginmodel.get(0).getName().toString());
                    editor.putString("regis", loginmodel.get(0).getRegisteruser_id().toString());
                    editor.commit();

                    //===========================

                    if (lmessage.equals("usrlogsucess")) {
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Loginmodel>> call, Throwable t) {

            }
        });
    }


}