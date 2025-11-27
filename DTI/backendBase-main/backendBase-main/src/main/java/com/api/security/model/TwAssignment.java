package com.api.security.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tw_asignacion")
public class TwAssignment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 
     * Relación con TwBien:
     * Muchas asignaciones pueden referirse al mismo bien.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bien", nullable = false)
    private TwGood bien;

    /**
     * Relación con usuario:
     * Muchas asignaciones pueden pertenecer al mismo usuario.
     * Si ya tienes una entidad TcUsuario o similar, cámbiala aquí.
     */
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion;

    @Column(name = "fecha_retorno")
    private LocalDate fechaRetorno;

    // --- Constructor vacío obligatorio para JPA ---
    public TwAssignment() {}

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TwGood getBien() {
        return bien;
    }

    public void setBien(TwGood bien) {
        this.bien = bien;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }
}
