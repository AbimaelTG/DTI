package com.api.security.dto;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String telefono;
	private String contraseña;
	private String claveServidor;
	private Integer nIdDependencias;
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
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getClaveServidor() {
		return claveServidor;
	}
	
	public void setClaveServidor(String claveServidor) {
		this.claveServidor = claveServidor;
	}
	
	public Integer getNIdDependencias() {
		return nIdDependencias;
	}
	
	public void setNIdDependencias(Integer nIdDependencias) {
		this.nIdDependencias = nIdDependencias;
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
				+ apellidoMaterno + ", correo=" + correo + ", telefono=" + telefono + ", contraseña=" + contraseña
				+ ", claveServidor=" + claveServidor + ", nIdDependencias=" + nIdDependencias + ", codigoVerificacion="
				+ codigoVerificacion + ", activo=" + activo + ", roles=" + roles + "]";
	}
}