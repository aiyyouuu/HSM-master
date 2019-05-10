package com.example.holiday.Presenter;

import android.content.Context;

import com.example.holiday.Connection.BaseApp;
import com.example.holiday.Model.login.get_user.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GetUserPresenter {
    private Context context;
    private GetUserView getUserView;

    public GetUserPresenter(Context context, GetUserView getUserView) {
        this.context = context;
        this.getUserView = getUserView;
    }

    public void ambil(String token){
        BaseApp.loginService.getUser(token).enqueue(new Callback<List<LoginResponse>>() {
            @Override
            public void onResponse(Call<List<LoginResponse>> call, retrofit2.Response<List<LoginResponse>> response){
                getUserView.onSucces(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                getUserView.onFailure(t.getMessage());
            }
        });
    }
}
