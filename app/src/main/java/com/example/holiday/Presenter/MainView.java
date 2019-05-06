package com.example.holiday.Presenter;

import com.example.holiday.Model.HolidayItem;

import java.util.List;

public interface MainView {
    void onSucces(List<HolidayItem> holidayItemList);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
