package com.example.holiday.Model;

import com.google.gson.annotations.SerializedName;

public class HolidayItem {
    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("date")
    private String date;

    @SerializedName("public")
    private String publicc;

    public String getPublicc() {
        return publicc;
    }

    public void setPublicc(String publicc) {
        this.publicc = publicc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return
                "HolidayItem{" +
                        "name = '" + name + '\'' +
                        "country = '" + country + '\'' +
                        "date = '" + date + '\'' +
                        "public = '" + publicc + '\'' +
                        "}";
    }


}
