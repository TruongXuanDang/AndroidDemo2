package com.truongdx8.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiManager {

    String SERVER = "http://tommyprivateguide.com";

    @GET("/data.json")
    Call<Item> getData();

    @GET("/datas.json")
    Call<List<PostModel>> getListNews(@Query("page") String page, @Query("per_page") String per_page);
}
