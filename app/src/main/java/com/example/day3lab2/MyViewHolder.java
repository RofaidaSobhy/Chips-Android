package com.example.day3lab2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView txtName;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.imageView);
        txtName=itemView.findViewById(R.id.txtName);

    }
}
