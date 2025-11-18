package com.api.security.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_rol_usuario")
public class TrRolUser implements Serializable {

    @EmbeddedId
    private TrRolUsuarioId id;

    public TrRolUser() {
    }

    public TrRolUser(Integer idRol, Integer idUsuario) {
        this.id = new TrRolUsuarioId(idRol, idUsuario);
    }

    public TrRolUsuarioId getId() {
        return id;
    }

    public void setId(TrRolUsuarioId id) {
        this.id = id;
    }

    @Embeddable
    public static class TrRolUsuarioId implements Serializable {
        @Column(name = "id_rol")
        private Integer idRol;

        @Column(name = "id_usuario")
        private Integer idUsuario;

        public TrRolUsuarioId() {
        }

        public TrRolUsuarioId(Integer idRol, Integer idUsuario) {
            this.idRol = idRol;
            this.idUsuario = idUsuario;
        }

        public Integer getIdRol() {
            return idRol;
        }

        public Integer getIdUsuario() {
            return idUsuario;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof TrRolUsuarioId))
                return false;
            TrRolUsuarioId that = (TrRolUsuarioId) o;
            return Objects.equals(idRol, that.idRol) && Objects.equals(idUsuario, that.idUsuario);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idRol, idUsuario);
        }
    }
}
