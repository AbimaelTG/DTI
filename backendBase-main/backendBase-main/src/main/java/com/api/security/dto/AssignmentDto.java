package com.api.security.dto;

import java.time.LocalDate;
import java.util.List;

public class AssignmentDto {
    
    private Long id;
    private Long idBien;
    private Long idUsuario;
    private LocalDate fechaAsignacion;
    private LocalDate fechaRetorno;

    private List<VoucherDto> comprobantes;

    public AssignmentDto(){

    }

    public AssignmentDto (Long id, Long idBien, Long idUsuario, LocalDate fechaAsignacion, LocalDate fechaRetorno,
                    List<VoucherDto> comprobantes){
        
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

    public Long getIdBien(){
        return idBien;
    }

    public void setIdBien(Long idBien){
        this.idBien = idBien;
    }

    public Long getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario){
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

    public List<VoucherDto> getComprobantes(){
        return comprobantes;
    }

    public void setComprobantes(List<VoucherDto> comprobantes){
        this.comprobantes = comprobantes;
    }
}
