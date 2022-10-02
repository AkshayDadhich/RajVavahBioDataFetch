package com.example.rajvivah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.example.rajvivah.modal.Loginmodel;
import com.example.rajvivah.webapi.Apiclient;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

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
    String names, regid;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;

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
        //===============================
        SharedPreferences mPrefs = getSharedPreferences("IDvalue", MODE_PRIVATE);
        names = mPrefs.getString("name", null);
        regid = mPrefs.getString("regis", null);
        //====================Biomatric login========================

        // Initialising msgtext and loginbutton
        TextView msgtex = findViewById(R.id.msgtext);
        // final Button loginbutton = findViewById(R.id.loginf);
        // creating a variable for our BiometricManager
        // and lets check if our user can use biometric sensor or not
        BiometricManager biometricManager = androidx.biometric.BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            // this means we can use biometric sensor
            case BiometricManager.BIOMETRIC_SUCCESS:
                msgtex.setText("You can use the fingerprint sensor to login");
                msgtex.setTextColor(Color.parseColor("#fafafa"));
                break;
            // this means that the device doesn't have fingerprint sensor
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:

                msgtex.setText("This device doesnot have a fingerprint sensor");
                //loginbutton.setVisibility(View.GONE);
                break;
            // this means that biometric sensor is not available
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                msgtex.setText("The biometric sensor is currently unavailable");
                //   loginbutton.setVisibility(View.GONE);
                break;
            // this means that the device doesn't contain your fingerprint
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
               // msgtex.setText("Your device doesn't have fingerprint saved,please check your security settings");
                //  loginbutton.setVisibility(View.GONE);
                if (names != null && regid != null) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    break;
                }

        }
        // creating a variable for our Executor
        Executor executor = ContextCompat.getMainExecutor(this);
        // this will give us result of AUTHENTICATION
        biometricPrompt = new BiometricPrompt(LoginActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            // THIS METHOD IS CALLED WHEN AUTHENTICATION IS SUCCESS
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                // Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                //  loginbutton.setText("Login Successful");
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        // creating a variable for our promptInfo
        // BIOMETRIC DIALOG
        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Welcome-DahejVirodhi Kshatriya Sangh")
                .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel").build();
      /*  loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);

            }
        });*/
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
        if (names != null && regid != null) {
            biometricPrompt.authenticate(promptInfo);
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