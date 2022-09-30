package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rajvivah.adapter.CourseAdapter;
import com.example.rajvivah.modal.Selfregistrationresponse;

import java.util.ArrayList;

public class Card_Recycler_View extends AppCompatActivity {

    private RecyclerView courseRV;

    // Arraylist for storing data
    private ArrayList<Selfregistrationresponse.CourseModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler_view);
        courseRV = findViewById(R.id.idRVCourse);

        // here we have created new array list and added data to it.
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Ankita", 1, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Charu", 3, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Poonam", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Nikita", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Divya", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Priyanka", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Simran", 4, R.drawable.girl));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }
}