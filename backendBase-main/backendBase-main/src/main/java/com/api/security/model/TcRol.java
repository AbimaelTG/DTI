package com.api.security.model;

import java.io.Serializable;

import com.api.enums.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tc_rol")
public class TcRol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="n_id")
	private Long nId;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "s_rol")
	private RolNombre sRol;


	public Long getnId() {
		return nId;
	}


	public void setnId(Long nId) {
		this.nId = nId;
	}


	public RolNombre getsRol() {
		return sRol;
	}


	public void setsRol(RolNombre sRol) {
		this.sRol = sRol;
	}


}
