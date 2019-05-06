package com.example.holiday.Connection;

import android.app.Application;

import com.example.holiday.BuildConfig;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApp extends Application {
    public static ApiService service;
    public static ApiLogin loginService;
    private String BASE_URL = "https://holidayapi.pl";
    private String BASE_URL2 = "https://yutub-api.herokuapp.com";
    @Override
    public void onCreate() {
        super.onCreate();
        service = getRetrofit().create(ApiService.class);
        loginService = getRetrofit2().create(ApiLogin.class);
    }
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();
    }

    private Retrofit getRetrofit2() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getHttpLogInterceptor())
                .build();
    }
    private Interceptor getHttpLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new
                HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level;
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            level = HttpLoggingInterceptor.Level.NONE;
        }
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
