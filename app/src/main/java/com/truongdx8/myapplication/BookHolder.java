package com.truongdx8.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookHolder extends RecyclerView.ViewHolder {

    ImageView ivCover;
    TextView tvName;
    public BookHolder(@NonNull View itemView) {
        super(itemView);
        ivCover = itemView.findViewById(R.id.ivCover);
        tvName = itemView.findViewById(R.id.tvName);
    }
}
