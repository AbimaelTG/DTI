package com.api.security.dto;

public class LoginUsuario {
	
	
	private String sUsuario;
	
	
	private String sPassword;


	public String getsUsuario() {
		return sUsuario;
	}


	public void setsUsuario(String sUsuario) {
		this.sUsuario = sUsuario;
	}


	public String getsPassword() {
		return sPassword;
	}


	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}


	@Override
	public String toString() {
		return "LoginUsuario [sUsuario=" + sUsuario + ", sPassword=" + sPassword + "]";
	}
	
	
	
	
}
