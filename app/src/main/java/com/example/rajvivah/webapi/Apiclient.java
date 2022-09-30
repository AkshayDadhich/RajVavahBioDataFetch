package com.example.rajvivah.webapi;

import com.example.rajvivah.uservice.Apimethods;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private static Retrofit getRetrofit()
    {
        HttpLoggingInterceptor httpLoggingInterceptor =new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://vsrajawat-001-site2.btempurl.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public static Apimethods getUserservice(){
        Apimethods apimethods=getRetrofit().create(Apimethods.class);
        return apimethods;
    }

}
