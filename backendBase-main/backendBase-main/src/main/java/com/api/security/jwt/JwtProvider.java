package com.api.security.jwt;

import java.security.Key;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.api.security.dto.JwtDto;
import com.api.security.dto.LoginUsuario;
import com.api.security.model.UsuarioPrincipal;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.*;



@Component
public class JwtProvider {

	/**
	 * genera token, valida y comprueba que no haya expirado
	 */

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;

	public String generateToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		return Jwts.builder()
				.setSubject(usuarioPrincipal.getUsername())
				.claim("nId", usuarioPrincipal.getnId())
				.claim("nombreUsuario", usuarioPrincipal.getsNombreUsuario())
				.claim("roles", roles)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 180))
				.signWith(getSecret(secret)).compact();
	}

	public String usuarioFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token);
			return true;

		} catch (MalformedJwtException e) {
			logger.equals("token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.equals("token no soportado");
		} catch (ExpiredJwtException e) {
			logger.equals("token expirado");
		} catch (IllegalArgumentException e) {
			logger.equals("token  vacío");
		}
		return false;
	}
	
	public String refreshToken(JwtDto jwtDto) throws ParseException {
		try {
			Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(jwtDto.getToken());
		}catch (ExpiredJwtException e) {
				logger.equals("token expirado");
				JWT jwt = JWTParser.parse(jwtDto.getToken());
				JWTClaimsSet claims = jwt.getJWTClaimsSet();
				String usuario = claims.getSubject();
				Long nId = (Long) claims.getClaim("nId");
				String nombreUsuario = (String) claims.getClaim("nombreUsuario");
				List<String> roles = (List<String>) claims.getClaim("roles");
				
				return Jwts.builder()
						.setSubject(usuario)
						.claim("nId", nId)
						.claim("nombreUsuario", nombreUsuario)
						.claim("roles", roles)
						.setIssuedAt(new Date())
						.setExpiration(new Date(new Date().getTime() + expiration))
						.signWith(getSecret(secret))
						.compact();
		}
		return null;
	}
	
	private Key getSecret(String secret) {	
		
		byte[] secreteBytes= Decoders.BASE64URL.decode(secret);
		return Keys.hmacShaKeyFor(secreteBytes); 
		
	}

}
