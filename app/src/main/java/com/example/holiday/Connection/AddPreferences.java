package com.example.holiday.Connection;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.holiday.Model.login.get_user.LoginResponse;
import com.example.holiday.R;

public class AddPreferences {
    private Context context;
    private SharedPreferences sharedPreferences;
    private LoginResponse loginResponse;

    public AddPreferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public void token(String token){
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token", token);
        editor.commit();
    }

    public String getToken(){
        return sharedPreferences.getString("Token", null);
    }

    public boolean readLoginStatus(){
        boolean status = false ;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }

    public void logout(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Token",token);
        editor.clear();
        editor.commit();
    }
}
