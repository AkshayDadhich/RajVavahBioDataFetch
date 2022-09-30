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
import com.example.rajvivah.modal.Selfregistrationresponse;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private Context context;
    private ArrayList<Selfregistrationresponse.CourseModel> courseModelArrayList;

    // Constructor
    public CourseAdapter(Context context, ArrayList<Selfregistrationresponse.CourseModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_display_card_view, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        Selfregistrationresponse.CourseModel model = courseModelArrayList.get(position);
        holder.person_name.setText(model.getCourse_name());
        holder.person_profession.setText("" + model.getCourse_rating());
        holder.person_pic.setImageResource(model.getCourse_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView person_pic;
        private TextView person_name, person_profession;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            person_pic = itemView.findViewById(R.id.person_pic);
            person_name = itemView.findViewById(R.id.person_name);
            person_profession = itemView.findViewById(R.id.person_profession);
        }
    }
}