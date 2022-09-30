package com.example.rajvivah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rajvivah.adapter.CourseAdapter;
import com.example.rajvivah.modal.Selfregistrationresponse;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Selfregistrationresponse.CourseModel> courseModelArrayList;

    public MatchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Ankita", 1, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Charu", 3, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Poonam", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Nikita", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Divya", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Priyanka", 4, R.drawable.girl));
        courseModelArrayList.add(new Selfregistrationresponse.CourseModel("Simran", 4, R.drawable.girl));
        CourseAdapter courseAdapter = new CourseAdapter(this.getContext(),courseModelArrayList);
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);
        return view;
    }
}