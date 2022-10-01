package com.example.rajvivah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajvivah.R;
import com.example.rajvivah.modal.Biodatafetchmodel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Biodatafetchadapter extends RecyclerView.Adapter<Biodatafetchadapter.ViewHolder> {

    private Context context;
    private ArrayList<Biodatafetchmodel> biodatafetchmodelArrayList;

    // creating a constructor class.
    public Biodatafetchadapter(Context context, ArrayList<Biodatafetchmodel> biodatafetchmodelArrayList) {
        this.context = context;
        this.biodatafetchmodelArrayList = biodatafetchmodelArrayList;
    }

    @NonNull
    @Override
    public Biodatafetchadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.course_rv_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Biodatafetchadapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        Biodatafetchmodel courses = biodatafetchmodelArrayList.get(position);
        holder.name.setText(courses.getName());
        holder.fathername.setText(courses.getFathername());
        holder.candidatemob.setText(courses.getCandidate_mob());
        Picasso.get().load(courses.getPath()).into(holder.userimage);
    }

    @Override
    public int getItemCount() {
        return biodatafetchmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView name,fathername,candidatemob;

        private final ImageView userimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            userimage = itemView.findViewById(R.id.userimage);
            name = itemView.findViewById(R.id.name);
            fathername = itemView.findViewById(R.id.et_father_name);
            candidatemob = itemView.findViewById(R.id.candidate_mob);
        }
    }
}
