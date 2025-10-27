package com.api.security.jwt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
	/**
	 * comprueba si hay un token valido si no regresa error 401 no autorizado
	 */
	
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
	 
	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
		
	}
	

}
