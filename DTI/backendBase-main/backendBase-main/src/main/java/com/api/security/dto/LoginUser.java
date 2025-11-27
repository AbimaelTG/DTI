package com.api.security.dto;

public class LoginUser {
    
    private String correo;
    private String contrasena;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "LoginUsuario [correo=" + correo + ", contrasena=" + contrasena + "]";
    }
}