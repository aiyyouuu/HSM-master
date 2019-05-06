package com.example.holiday.Model.login.postlogin;

public class PostLoginResponse{
	private boolean auth;
	private String token;

	public void setAuth(boolean auth){
		this.auth = auth;
	}

	public boolean isAuth(){
		return auth;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"PostLoginResponse{" + 
			"auth = '" + auth + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
