package com.example.holiday.Presenter;

import com.example.holiday.Model.login.get_user.LoginResponse;

public interface GetUserView {
    void onSucces(LoginResponse loginResponse);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
