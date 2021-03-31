package com.example.testmapboxapp;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApiService {
    @POST("users")
    Call<UserWrapper> getUserList();
}