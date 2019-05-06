package com.example.holiday.Presenter;

public interface RegisView {
    void onSucces(String regis);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
