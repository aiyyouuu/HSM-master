package com.example.holiday.Presenter;

import com.example.holiday.Model.login.postlogin.PostLoginResponse;

public interface LoginView {
    void onSucces(PostLoginResponse login);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
