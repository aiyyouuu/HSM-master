package com.example.holiday.Model.login.update;

public class PhotoProfile{
	private String photoUrl;
	private String idPhoto;

	public void setPhotoUrl(String photoUrl){
		this.photoUrl = photoUrl;
	}

	public String getPhotoUrl(){
		return photoUrl;
	}

	public void setIdPhoto(String idPhoto){
		this.idPhoto = idPhoto;
	}

	public String getIdPhoto(){
		return idPhoto;
	}

	@Override
 	public String toString(){
		return 
			"PhotoProfile{" + 
			"photo_url = '" + photoUrl + '\'' + 
			",id_photo = '" + idPhoto + '\'' + 
			"}";
		}
}
