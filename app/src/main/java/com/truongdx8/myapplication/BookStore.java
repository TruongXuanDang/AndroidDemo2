package com.truongdx8.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class BookStore extends AppCompatActivity {
    List<BookItem> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);

        initData();

        BookAdapter adapter = new BookAdapter(this,bookList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        RecyclerView rvBook = findViewById(R.id.rvBookStore);
        rvBook.setLayoutManager(layoutManager);
        rvBook.setAdapter(adapter);
    }

    private void initData ()
    {
        bookList.add(new BookItem(R.drawable.book1,"Book1"));
        bookList.add(new BookItem(R.drawable.book4,"Book4"));
        bookList.add(new BookItem(R.drawable.book7,"Book7"));
        bookList.add(new BookItem(R.drawable.book1,"Book1"));
    }
}
