package com.example.holiday.Connection;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.holiday.R;

public class sharedpreference {
    private SharedPreferences sharedPreferences;
    private Context context;

    public sharedpreference(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
    }

    public void token(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
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
}
