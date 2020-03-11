package com.example.mobile.api;

import com.example.mobile.models.LoginResponse;
import com.example.mobile.models.AnnoncesResponse;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;



public interface Api {
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(
            @Field("login") String login,
            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> Login(
            @Field("email") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("annonce/addannonce")
    Call<ResponseBody> addannonce(
            @Field("category") String login,
            @Field("title") String email,
            @Field("description") String password,
            @Field("price") int price,
            @Field("number") String number,
            @Field("user_id") String user_id

    );

    @GET("allannonces")
    Call<AnnoncesResponse> getAnnonces();

}
