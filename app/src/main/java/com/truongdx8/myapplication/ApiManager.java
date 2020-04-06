package com.truongdx8.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiManager {

    String SERVER = "http://tommyprivateguide.com";

    @GET("/data.json")
    Call<Item> getData();
}
