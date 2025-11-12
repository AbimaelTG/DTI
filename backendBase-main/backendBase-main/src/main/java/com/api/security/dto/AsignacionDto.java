package com.api.security.dto;

import java.time.LocalDate;
import java.util.List;

public class AsignacionDto {
    
    private Long id;
    private Integer idBien;
    private Integer idUsuario;
    private LocalDate fechaAsignacion;
    private LocalDate fechaRetorno;

    private List<ComprobanteDto> comprobantes;

    public AsignacionDto(){

    }

    public AsignacionDto (Long id, Integer idBien, Integer idUsuario, LocalDate fechaAsignacion, LocalDate fechaRetorno,
                    List<ComprobanteDto> comprobantes){
        
        this.id = id;
        this.idBien = idBien;
        this.idUsuario = idUsuario;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaRetorno = fechaRetorno;
        this.comprobantes = comprobantes;

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Integer getIdBien(){
        return idBien;
    }

    public void setIdBien(Integer idBien){
        this.idBien = idBien;
    }

    public Integer getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario){
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaAsignacion(){
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion){
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDate getFechaRetorno(){
        return fechaRetorno;
    }

    public void setFechaRetorno(LocalDate fechaRetorno){
        this.fechaRetorno = fechaRetorno;
    }

    public List<ComprobanteDto> getComprobantes(){
        return comprobantes;
    }

    public void setComprobantes(List<ComprobanteDto> comprobantes){
        this.comprobantes = comprobantes;
    }
}
