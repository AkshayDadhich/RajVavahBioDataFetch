package com.example.rajvivah.uservice;

import com.example.rajvivah.modal.Biodatafetchmodel;
import com.example.rajvivah.modal.Biodataregistrationmodel;
import com.example.rajvivah.modal.Loginmodel;
import com.example.rajvivah.modal.Rajputcastmodel;
import com.example.rajvivah.modal.RegistrationModel;
import com.example.rajvivah.modal.Responseversioncheck;
import com.example.rajvivah.modal.Signupresponse;
import com.example.rajvivah.modal.Userrequest;
import com.example.rajvivah.modal.Userresponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apimethods {
    /*------------Biodata fetch--------------------*/
    @GET("Biodataregistration/getallbiodata?")
    Call<List<Biodatafetchmodel>> fetchallbioData(@Query("pagefrom") int pagefrom, @Query("pageto") int pageto);


    /*---------------------------------------*/
    @POST("api/Testapi")
    Call<Userresponse> saveUser(@Body Userrequest userrequest);

    @GET("Appversion/getcheckedappVersion?")
    Call<List<Responseversioncheck>> checkapplatestVersion(@Query("id") String id);

    @GET("Appversion/getinstalledappversion?strversion=1.0")
    Call<List<Responseversioncheck>> installedversionDetails();

    @GET("Castselect/getallcast")
    Call<List<Rajputcastmodel>> getallCast();

    @GET("Castselect/getgotra")
    Call<List<Rajputcastmodel>> getallGotra(@Query("rid") int id);

    @GET("Userregistration/getdvksdatabyid?")
    Call<List<RegistrationModel>> getuserProfile(@Query("registeruser_id") String id);

    @GET("Userregistration/getprofileimageurl?registeruser_id=1")
    Call<List<Responseversioncheck>> getuserprofileimageUrl();

    @GET("Welcomeflashscreen/getwelcomeflashScreen")
    Call<List<Responseversioncheck>> getwelcomeflashScreen();

    @GET("Userlogin/validateuserlogin?")
    Call<List<Loginmodel>> getuserLogin(@Query("usr") String usr, @Query("pwd") String pwd);

    //=========== Register new user======================
    @FormUrlEncoded
    @POST("Userlogin/signupuser")
    Call<Signupresponse> signupUser(
            @Field("registeruser_mob") String registeruser_mob,
            @Field("registeruser_mail") String registeruser_mail,
            @Field("reg_can_password") String reg_can_password
    );

    @POST("Userlogin/signupuser")
    Call<Signupresponse> createPost(@Body Signupresponse signupresponse);

    @POST("Biodataregistration/postbiodatafirsttime")
    Call<Biodataregistrationmodel> postBiodata(@Body Biodataregistrationmodel biodataregistrationmodel);
}
