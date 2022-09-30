package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.DataModal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("Selffirstreg")
  Call<DataModal> createPost(@Body DataModal dataModal);
}
