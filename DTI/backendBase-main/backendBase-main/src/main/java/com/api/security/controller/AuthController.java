package com.api.security.controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.security.dto.*;
import com.api.security.jwt.*;
import com.api.security.model.TcUser;
import com.api.security.service.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/", methods = { RequestMethod.GET, RequestMethod.POST })
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private UserServiceImp usuarioService;

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@RequestBody LoginUser loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity("campos incorrectos", HttpStatus.BAD_REQUEST);
		}
		System.err.println("datos de acceso: " + loginUsuario);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(), loginUsuario.getContrasena()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		JwtDto jwtDto = new JwtDto(jwt);
		System.err.println(jwtDto);
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}

	@PostMapping("/refresh")
	public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
		System.out.println(jwtDto.getToken());
		String token = jwtProvider.refreshToken(jwtDto);
		JwtDto jwt = new JwtDto(token);
		return new ResponseEntity(jwt, HttpStatus.OK);
	}

	@PostMapping("/usuario")
	public ResponseEntity<?> nuevo(@RequestBody User nuevoUsuario, BindingResult bindingResult) {

		System.err.println("Datos de nuevo usuario: " + nuevoUsuario);

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}
		if (usuarioService.existsByCorreo(nuevoUsuario.getCorreo())) {
			return new ResponseEntity<>("El correo ya está registrado", HttpStatus.BAD_REQUEST);
		}

		try {
			usuarioService.save(nuevoUsuario);
			return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);

		} catch (Exception e) {
			System.err.println("Error al crear usuario: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Error interno al crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody User nuevoUsuario,
			BindingResult bindingResult) {

		System.err.println("Actualizando usuario ID: " + id + " con datos: " + nuevoUsuario);

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}

		if (!usuarioService.existsById(id)) {
			return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
		}

		if (nuevoUsuario.getCorreo() != null) {
			Optional<TcUser> usuarioConCorreo = usuarioService.getByCorreo(nuevoUsuario.getCorreo());
			if (usuarioConCorreo.isPresent() && !usuarioConCorreo.get().getId().equals(id)) {
				return new ResponseEntity<>("El correo ya está registrado por otro usuario", HttpStatus.BAD_REQUEST);
			}
		}

		try {
			usuarioService.update(id, nuevoUsuario);
			return new ResponseEntity<>("Usuario actualizado exitosamente", HttpStatus.OK);

		} catch (Exception e) {
			System.err.println("Error al actualizar usuario: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Error interno al actualizar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		try {
			usuarioService.delete(id);
			return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error al eliminar usuario: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Error interno al eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
