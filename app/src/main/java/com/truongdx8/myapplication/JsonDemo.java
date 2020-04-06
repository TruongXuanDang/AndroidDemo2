package com.truongdx8.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonDemo extends AppCompatActivity {

    public static final String TAG = "TAG_RESPONSE";
    TextView tvDate, tvTitle;
    ImageView ivCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_demo);

        tvDate = findViewById(R.id.tvDate);
        tvTitle = findViewById(R.id.tvTitle);
        ivCover = findViewById(R.id.ivImage);
        getData();

        //B1: Build.gradle
        //B2: Create interface
        //B3: Create Object Item
        //Note: Manifest: Xin quyen internet
    }

    private void getData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager apiManager = retrofit.create(ApiManager.class);
        apiManager.getData().enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Log.d("MainActivity","message");
                Item data = response.body();

                tvDate.setText(data.getDate());
                tvTitle.setText(data.getTitle());

                Glide.with(JsonDemo.this).load(data.getImage()).into(ivCover);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });
    }
}
