package com.example.holiday.Model.login.get_user;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{
	@SerializedName("name")
	String nama;
	@SerializedName("email")
	String email;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
