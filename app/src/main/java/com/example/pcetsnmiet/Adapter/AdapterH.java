package com.example.pcetsnmiet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.model.MainModel;

import java.util.ArrayList;

public class AdapterH extends RecyclerView.Adapter<AdapterH.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;

    public AdapterH(Context context,ArrayList<MainModel> mainModels)
    {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recy_lay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModels.get(position).getImg());
        holder.textView.setText(mainModels.get(position).getCourse_name());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.branch_img);
            textView = itemView.findViewById(R.id.branch_name);
        }
    }
}
