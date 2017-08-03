package com.meridianid.farizdotid.mahasiswaapp.model;

import com.google.gson.annotations.SerializedName;

public class ResponseDosenDetail{

	@SerializedName("nama")
	private String nama;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	@SerializedName("matkul")
	private String matkul;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
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
			"ResponseDosenDetail{" + 
			"nama = '" + nama + '\'' + 
			",no_hp = '" + noHp + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",matkul = '" + matkul + '\'' + 
			"}";
		}
}