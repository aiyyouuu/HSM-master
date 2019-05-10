package com.example.holiday.Connection;

import com.example.holiday.Model.login.get_user.LoginResponse;
import com.example.holiday.Model.login.postlogin.PostLoginResponse;
import com.example.holiday.Model.login.update.CreateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiLogin {
    @FormUrlEncoded
    @POST("/users/login")
    Call<PostLoginResponse> PostUserResponse (@Field("email") String email,
                                              @Field("password") String pass);

    @FormUrlEncoded
    @POST("/users")
    Call<Void> PostCreate (@Field("email") String email,
                           @Field("password") String pass,
                           @Field("name") String name);

    @GET("/users/")
    Call<List<LoginResponse>> getUser (@Header("x-access-token") String token);

    @FormUrlEncoded
    @PUT("/users/")
    Call<CreateResponse> updateUser (@Header("x-access-token") String token,
                                     @Field("name") String name);
}
