package com.example.holiday.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidayResponse {

    @SerializedName("holidays")
    private List<HolidayItem> holidays;

    @SerializedName("status")
    private String status;

    public List<HolidayItem> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<HolidayItem> holidays) {
        this.holidays = holidays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return
                "HolidayResponse{ " +
                        ", holidays = '" + holidays + '\'' +
                        ", status = '" + status + '\'' +
                        "}";
    }
}
