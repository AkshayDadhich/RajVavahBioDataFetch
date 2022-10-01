package com.example.rajvivah;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajvivah.adapter.Biodatafetchadapter;
import com.example.rajvivah.modal.Biodatafetchmodel;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodatadisplayActivity extends AppCompatActivity {

    int count = 0;
    private ArrayList<Biodatafetchmodel> courseArrayList;
    private RecyclerView courseRV;
    private Biodatafetchadapter biodatafetchadapter;
    private ProgressBar loadingPB;
    private NestedScrollView nestedSV;
    int pagefrom=1, pageto=100;
    List<Biodatafetchmodel> biodatafetchmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodatadisplay);
        courseRV = findViewById(R.id.idRVCourses);
        loadingPB = findViewById(R.id.idPBLoading);
        nestedSV = findViewById(R.id.idNestedSV);
        courseArrayList = new ArrayList<>();
        biodatafetchFunction();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setLayoutManager(manager);
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    count++;
                    loadingPB.setVisibility(View.VISIBLE);
                    if (count <=20) {
                         pagefrom+=20;
                         pageto+=20;
                        biodatafetchFunction();
                    }
                }
            }
        });
    }

    public void biodatafetchFunction() {
        try {
            courseRV.setVisibility(View.VISIBLE);
            Call<List<Biodatafetchmodel>> userList = Apiclient.getUserservice().fetchallbioData(pagefrom,pageto);
            userList.enqueue(new Callback<List<Biodatafetchmodel>>() {
                @Override
                public void onResponse(Call<List<Biodatafetchmodel>> call, Response<List<Biodatafetchmodel>> response) {
                    try {

                        biodatafetchmodelList = new ArrayList<Biodatafetchmodel>();
                        biodatafetchmodelList.addAll(response.body());
                        String[] profiledetails = new String[biodatafetchmodelList.size()];
                        if (response.isSuccessful()) {
                            for (int i = 0; i < 10; i++) {
                               // profiledetails[i] = biodatafetchmodelList.get(i).getName();
                                String name =  profiledetails[i];
                                String fathername = biodatafetchmodelList.get(i).getFathername();
                                String mobile = biodatafetchmodelList.get(i).getCandidate_mob();
                                String path =biodatafetchmodelList.get(i).getPath();
                                courseArrayList.add(new Biodatafetchmodel(name, fathername, mobile,path));
                                biodatafetchadapter = new Biodatafetchadapter(BiodatadisplayActivity.this, courseArrayList);
                                courseRV.setAdapter(biodatafetchadapter);

                            }
                        }

                    } catch (Exception e) {

                    }


                }

                @Override
                public void onFailure(Call<List<Biodatafetchmodel>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }


}
