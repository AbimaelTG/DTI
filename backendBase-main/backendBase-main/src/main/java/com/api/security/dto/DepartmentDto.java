package com.api.security.dto;

import java.io.Serializable;

public class DepartmentDto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;

    public DepartmentDto(){

    }

    public DepartmentDto(Long id, String nombre){

        this.id = id;
        this.nombre = nombre;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "DepartamentoDto [id = "+ id + ", nombre = " + nombre + "]";
    }
}
