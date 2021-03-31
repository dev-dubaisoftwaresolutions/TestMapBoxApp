package com.example.testmapboxapp;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApiService {
    @POST("bfde1863")
    Call<UserWrapper> getUserList();
}