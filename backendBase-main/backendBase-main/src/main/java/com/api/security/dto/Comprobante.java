package com.api.security.dto;

import java.time.LocalDate;

public class Comprobante {

    private Long id;
    private LocalDate fechaEmision;
    private Long idAsignacion;

    public Comprobante(){

    }

    public Comprobante(long id, LocalDate fechaEmision, Long idAsignacion){
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.idAsignacion = idAsignacion;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public LocalDate getFechaEmision(){
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision){
        this.fechaEmision = fechaEmision;
    }

    public Long getIdAsignacion(){
        return idAsignacion;
    }

    public void setIdAsignacion(Long idAsigncaion){
        this.idAsignacion = idAsigncaion;
    }
    
}
