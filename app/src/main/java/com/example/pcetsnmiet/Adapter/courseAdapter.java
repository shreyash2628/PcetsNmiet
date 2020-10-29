package com.example.pcetsnmiet.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.model.modelCourseOffered;

import java.util.List;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder> {
    private List<modelCourseOffered> modelCourseOfferedList;

    public courseAdapter(List<modelCourseOffered> modelCourseOfferedList) {
        this.modelCourseOfferedList = modelCourseOfferedList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.courses_recyler_hori,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String dcode =modelCourseOfferedList.get(position).getDteCode();
        String intake = modelCourseOfferedList.get(position).getIntake();
        String courseName = modelCourseOfferedList.get(position).getCourseName();

        holder.setData(dcode,intake,courseName);
    }

    @Override
    public int getItemCount() {
        return modelCourseOfferedList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView dtecode;
        private TextView intake;
        private TextView courseName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dtecode = itemView.findViewById(R.id.dte_code);
            intake = itemView.findViewById(R.id.intake);
            courseName = itemView.findViewById(R.id.course_name);

        }


        private  void setData(String dte,String intke,String course)
        {
            dtecode.setText(dte);
            intake.setText(intke);
            courseName.setText(course);

        }

    }


}
