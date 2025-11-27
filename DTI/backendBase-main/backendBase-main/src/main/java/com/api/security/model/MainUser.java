package com.api.security.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Long nId;
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
	private Collection<? extends GrantedAuthority> authorities;
	
	public MainUser(Long nId, String nombre, String apellidoPaterno, String apellidoMaterno, 
							String correo, String telefono, String contraseña, String claveServidor,
							Integer nIdDependencias, String codigoVerificacion, Boolean activo,
							Collection<? extends GrantedAuthority> authorities) {
		this.nId = nId;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.claveServidor = claveServidor;
		this.nIdDependencias = nIdDependencias;
		this.codigoVerificacion = codigoVerificacion;
		this.activo = activo;
		this.authorities = authorities;
	}
	
	/**
	 * Se encarga de asignar los privilegios a cada usuario ya sea admin o user 
	 * @param usuario
	 * @return
	 */
	public static MainUser build(TcUser usuario) {
		
		// Obtiene los roles
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRol().name()))
				.collect(Collectors.toList());
		
		// Regresa el usuario con sus privilegios
		return new MainUser(
			usuario.getId(),
			usuario.getNombre(),
			usuario.getApellidoPaterno(),
			usuario.getApellidoMaterno(),
			usuario.getCorreo(),
			usuario.getTelefono(),
			usuario.getContrasena(),
			usuario.getClaveServidor(),
			usuario.getIdDependencia(),
			usuario.getCodigoVerificacion(),
			usuario.getActivo(),
			authorities
		);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return contraseña;
	}
	
	@Override
	public String getUsername() {
		return correo; // Usamos el correo como username para autenticación
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return activo != null ? activo : true;
	}

	// Getters
	public Long getnId() {
		return nId;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getClaveServidor() {
		return claveServidor;
	}

	public Integer getnIdDependencias() {
		return nIdDependencias;
	}

	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public Boolean getActivo() {
		return activo;
	}
	
	// Método para obtener el nombre completo
	public String getNombreCompleto() {
		return nombre + " " + apellidoPaterno + (apellidoMaterno != null ? " " + apellidoMaterno : "");
	}
}