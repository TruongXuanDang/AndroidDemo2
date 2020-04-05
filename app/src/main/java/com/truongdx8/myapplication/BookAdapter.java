package com.truongdx8.myapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<BookItem> bookItems;

    public BookAdapter(Activity activity, List<BookItem> bookItems) {
        this.activity = activity;
        this.bookItems = bookItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_bookitem,parent,false);
        BookHolder holder = new BookHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BookHolder bookHolder = (BookHolder) holder;
        BookItem data = bookItems.get(position);

        bookHolder.ivCover.setImageResource(data.cover);
        bookHolder.tvName.setText(data.name);
    }

    @Override
    public int getItemCount() {
        return bookItems.size();
    }
}
