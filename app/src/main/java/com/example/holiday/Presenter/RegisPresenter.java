package com.example.holiday.Presenter;

import android.content.Context;

import com.example.holiday.Connection.BaseApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisPresenter {
    private Context context;
    private RegisView regisView;

    public RegisPresenter(Context context, RegisView regisView) {
        this.context = context;
        this.regisView = regisView;
    }

    public void create(String name, String email, String password){
        BaseApp.loginService.PostCreate(email,password,name).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    regisView.onSucces(response.message());
                } else {
                    regisView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                regisView.onFailure(t.getMessage());
            }
        });

    }
}
