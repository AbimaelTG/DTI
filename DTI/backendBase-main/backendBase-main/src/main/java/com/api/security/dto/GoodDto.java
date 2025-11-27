package com.api.security.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GoodDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String codigoInventario;
    private String descripcion;
    private String marca;
    private String modelo;
    private String noSerie;
    private String estado;
    private Long idCategoria;
    private Long idDependencia;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;

    public GoodDto() {

    }

    public GoodDto(Long id, String codigoInventario, String descripcion, String marca, String modelo, String noSerie,
            String estado, Long idCategoria, Long idDependencia, LocalDate fechaAlta, LocalDate fechaBaja) {

        this.id = id;
        this.codigoInventario = codigoInventario;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.noSerie = noSerie;
        this.estado = estado;
        this.idCategoria = idCategoria;
        this.idDependencia = idDependencia;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Long idDependencia) {
        this.idDependencia = idDependencia;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "BienDto [id = " + id + ", codigoInventario = " + codigoInventario + ", descriçion = " + descripcion
                + ", marca = " + marca + ", modelo = " + modelo + ", noSerie = " + noSerie + ", estado = " + estado
                + ", idCategoria = " + idCategoria + ", idDependencia = " + idDependencia + ", fechaAlta = " + fechaAlta
                + ", fechaBaja = " + fechaBaja + "]";
    }

}