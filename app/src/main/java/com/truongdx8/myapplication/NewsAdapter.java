package com.truongdx8.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<PostModel> postItems;

    public NewsAdapter(Activity activity, List<PostModel> postItems) {
        this.activity = activity;
        this.postItems = postItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_newsitem,parent,false);
        NewsHolder holder = new NewsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsHolder newsHolder = (NewsHolder) holder;
        PostModel data = postItems.get(position);

        Glide.with(activity).load(data.getImage()).into(newsHolder.ivCover);
        newsHolder.tvTitle.setText(data.getTitle());
        newsHolder.tvContent.setText(data.getContent());
        newsHolder.tvDate.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }
}
