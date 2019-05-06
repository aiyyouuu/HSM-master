package com.example.holiday.Connection;

import com.example.holiday.Model.HolidayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v1/holidays")
    Call<HolidayResponse> getHoliday(@Query("country") String country,
                                     @Query("year") String year,
                                     @Query("month") String month);
}
