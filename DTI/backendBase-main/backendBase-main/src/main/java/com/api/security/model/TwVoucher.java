package com.api.security.model;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "tw_comprobante")
public class TwVoucher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_asignacion")
    private Long idAsignacion;

    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

    public TwVoucher() {}

    public TwVoucher(Long idAsignacion, LocalDate fechaEmision) {
        this.idAsignacion = idAsignacion;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Long idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "TwComprobante [id=" + id + ", idAsignacion=" + idAsignacion + ", fechaEmision=" + fechaEmision + "]";
    }
}
