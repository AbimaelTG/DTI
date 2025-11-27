package com.api.security.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tc_usuario")
public class TcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido_paterno")
	private String apellidoPaterno;

	@Column(name = "apellido_materno")
	private String apellidoMaterno;

	@Column(name = "correo")
	private String correo;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "clave_servidor")
	private String claveServidor;

	@Column(name = "id_dependencia")
	private Integer idDependencia;

	@Column(name = "codigo_verificacion")
	private String codigoVerificacion;

	@Column(name = "activo")
	private Boolean activo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tr_rol_usuario", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private Set<TcRol> roles = new HashSet<>();

	public TcUser() {
	}

	// Constructor completo
	public TcUser(String nombre, String apellidoPaterno, String apellidoMaterno,String correo, String telefono, String contrasena,String claveServidor, Integer idDependencia,String codigoVerificacion, Boolean activo) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.claveServidor = claveServidor;
		this.idDependencia = idDependencia;
		this.codigoVerificacion = codigoVerificacion;
		this.activo = activo;
	}

	// Getters y Setters
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getClaveServidor() {
		return claveServidor;
	}

	public void setClaveServidor(String claveServidor) {
		this.claveServidor = claveServidor;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(String codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Set<TcRol> getRoles() {
		return roles;
	}

	public void setRoles(Set<TcRol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "TcUsuario [Id=" + Id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", telefono=" + telefono
				+ ", contrasena=" + contrasena + ", claveServidor=" + claveServidor + ", idDependencia="
				+ idDependencia + ", codigoVerificacion=" + codigoVerificacion + ", activo=" + activo + ", roles="
				+ roles + "]";
	}
}