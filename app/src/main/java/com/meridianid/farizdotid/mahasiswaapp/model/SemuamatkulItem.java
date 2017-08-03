package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

public class SemuamatkulItem{

	@SerializedName("nama_dosen")
	private String namaDosen;

	@SerializedName("id")
	private String id;

	@SerializedName("matkul")
	private String matkul;

	public void setNamaDosen(String namaDosen){
		this.namaDosen = namaDosen;
	}

	public String getNamaDosen(){
		return namaDosen;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMatkul(String matkul){
		this.matkul = matkul;
	}

	public String getMatkul(){
		return matkul;
	}

	@Override
 	public String toString(){
		return 
			"SemuamatkulItem{" + 
			"nama_dosen = '" + namaDosen + '\'' + 
			",id = '" + id + '\'' + 
			",matkul = '" + matkul + '\'' + 
			"}";
		}
}