package com.truongdx8.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonHomework extends AppCompatActivity {

    List<PostModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_homework);

        getJsonData();

        NewsAdapter adapter = new NewsAdapter(this,list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        RecyclerView rvNews = findViewById(R.id.rvNews);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(adapter);
    }

    private void getJsonData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        apiManager.getListNews("1","50").enqueue(new Callback<List<PostModel>>() {

            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                list = response.body();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.d("MainActivity","message");
            }
        });
    }
}
