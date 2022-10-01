package com.example.rajvivah;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rajvivah.modal.Biodatafetchmodel;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodatafetchActivity extends AppCompatActivity {
    List<Biodatafetchmodel> biodatafetchmodelList;
    Dialog dialog;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biodatafetch);
        biodatafetchFunction();
        name=findViewById(R.id.name);
        biodatafetchFunction();
    }

    public void biodatafetchFunction() {

        try {

            dialog = ProgressDialog.show(
                    BiodatafetchActivity.this, "", "Please wait...");
            dialog.dismiss();
            Call<List<Biodatafetchmodel>> userList = Apiclient.getUserservice().fetchallbioData(1,10);
            userList.enqueue(new Callback<List<Biodatafetchmodel>>() {
                @Override
                public void onResponse(Call<List<Biodatafetchmodel>> call, Response<List<Biodatafetchmodel>> response) {

                    try {

                        biodatafetchmodelList = new ArrayList<Biodatafetchmodel>();
                        biodatafetchmodelList.addAll(response.body());
                        String[] profiledetails = new String[biodatafetchmodelList.size()];
                        if (response.isSuccessful()) {
                           // name.setText(biodatafetchmodelList.get(0).getName());
                            Toast.makeText(BiodatafetchActivity.this, "Name "+ biodatafetchmodelList.get(0).getName(),
                                    Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }

                    } catch (Exception e) {
                        dialog.dismiss();
                    }


                }

                @Override
                public void onFailure(Call<List<Biodatafetchmodel>> call, Throwable t) {
                    dialog.dismiss();
                }
            });
        } catch (Exception e) {
            dialog.dismiss();
        }


    }


}