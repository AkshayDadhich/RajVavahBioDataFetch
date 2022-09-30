package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.RegistrationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface vivahAPIGetRegistration {
    //http://vsrajawat-001-site2.btempurl.com/api/Sel/getdvksdatabyid?registeruser_id=4
    @GET("getdvksdatabyid?registeruser_id=4")
    Call<List<RegistrationModel>> getBiodata();
}
