package com.api.security.dto;

import java.io.Serializable;

public class DependenceDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String ubicacion;
    private String responsable;
    private Integer idDepartamento;

    public DependenceDto() {

    }

    public DependenceDto(Long id, String nombre, String ubicacion, String responsable, Integer idDepartamento) {

        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.responsable = responsable;
        this.idDepartamento = idDepartamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "DependenciaDto [id = " + id + ", nombre = " + nombre + ", ubicacion = " + ubicacion + ", responsable = "
                + responsable + ", idDepartamento = " + idDepartamento + "]";
    }

}
