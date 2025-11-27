package com.api.security.dto;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String telefono;
	private String contrasena;
	private String claveServidor;
	private Integer idDependencia;
	private String codigoVerificacion;
	private Boolean activo;
	private Set<String> roles = new HashSet<>();
	
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
	
	public Set<String> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "NuevoUsuario [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", correo=" + correo + ", telefono=" + telefono + ", contrasena=" + contrasena
				+ ", claveServidor=" + claveServidor + ", idDependencia=" + idDependencia + ", codigoVerificacion="
				+ codigoVerificacion + ", activo=" + activo + ", roles=" + roles + "]";
	}
}