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
       holder.gender.setText(courses.getGender_self());
         //holder.candidatedob.setText(courses.getName());
        holder.candidatecast.setText(courses.getCandidate_cast());
        holder.candidategotra.setText(courses.getCandidate_gotra());
        holder.candidatefather.setText(courses.getFathername());
        holder.candidatemother.setText(courses.getMothername());
        holder.candidatemobile.setText(courses.getCandidate_mob());
        holder.candidateaddress.setText(courses.getCandidate_address());

        Picasso.get().load(courses.getPath()).into(holder.userimage);
    }

    @Override
    public int getItemCount() {
        return biodatafetchmodelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView name, gender,  candidatecast, candidategotra,candidatefather;
        private final TextView  candidatemother,candidatemobile, candidateaddress;
        private final ImageView userimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            userimage = itemView.findViewById(R.id.userimage);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            //candidatedob = itemView.findViewById(R.id.candidatedob);
            candidatecast = itemView.findViewById(R.id.candidatecast);
            candidategotra = itemView.findViewById(R.id.candidategotra);
            candidatefather = itemView.findViewById(R.id.candidatefather);
            candidatemother = itemView.findViewById(R.id.candidatemother);
            candidatemobile = itemView.findViewById(R.id.candidatemobile);
            candidateaddress = itemView.findViewById(R.id.candidateaddress);

        }
    }
}
