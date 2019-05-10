package com.example.holiday.Presenter;

import com.example.holiday.Model.login.update.CreateResponse;

public interface UpdateView {
    void onSucces(CreateResponse update);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
