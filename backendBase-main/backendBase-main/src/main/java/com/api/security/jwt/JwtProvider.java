package com.api.security.jwt;

import java.security.Key;
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
import com.api.security.model.MainUser;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        MainUser usuarioPrincipal = (MainUser) authentication.getPrincipal();
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .claim("nId", usuarioPrincipal.getnId())
                .claim("nombre", usuarioPrincipal.getNombre())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180))
                .signWith(getSecret(secret)).compact();
    }

    public String usuarioFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token).getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token);
            return true;

        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacío");
        }
        return false;
    }

    public String refreshToken(JwtDto jwtDto) throws ParseException {
        try {
            Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(jwtDto.getToken());

            logger.info("Token aún válido, no necesita refresh");
            return null;

        } catch (ExpiredJwtException e) {
            logger.info("Token expirado, generando nuevo token");

            Claims claims = e.getClaims();

            String usuario = claims.getSubject();
            Long nId = claims.get("nId", Long.class);
            String nombre = claims.get("nombre", String.class);
            List<String> roles = claims.get("roles", List.class);

            return Jwts.builder()
                    .setSubject(usuario)
                    .claim("nId", nId)
                    .claim("nombre", nombre)
                    .claim("roles", roles)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + expiration * 1000L))
                    .signWith(getSecret(secret))
                    .compact();

        } catch (Exception e) {
            logger.error("Error al refrescar token: " + e.getMessage());
            return null;
        }
    }

    private Key getSecret(String secret) {
        byte[] secreteBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secreteBytes);
    }
}