package com.api.security.dto;

import java.io.Serializable;

public class RolUserDto implements Serializable{

    public static final long serialVersionUID = 1L;

    private Long idRol;
    private Long idUsuario;

    public RolUserDto(){

    }

    public RolUserDto(Long idRol, Long idUsuario){

        this.idRol = idRol;
        this.idUsuario = idUsuario;
    }

    public Long getIdRol(){
        return idRol;
    }

    public void setIdRol(Long idRol){
        this.idRol = idRol;
    }

    public Long getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
    }
    
    @Override
    public String toString(){
        return "RolUsuarioDto [idRol = " + idRol + ", idUsuario = " + idUsuario + "]";
    }
}
