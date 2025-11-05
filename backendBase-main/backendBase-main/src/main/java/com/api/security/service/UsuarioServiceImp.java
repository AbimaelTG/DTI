package com.api.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.enums.RolNombre;
import com.api.security.dto.NuevoUsuario;
import com.api.security.model.TcRol;
import com.api.security.model.TcUsuario;
import com.api.security.repository.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImp {

    @Autowired
    public UsuariosRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolServiceImpl rolServiceImpl;

    // CAMBIA ESTOS MÉTODOS - buscan por correo, no por nombre de usuario
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    public Optional<TcUsuario> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<TcUsuario> getByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    // Si necesitas mantener compatibilidad, puedes dejar estos pero que usen correo
    // internamente
    public Optional<TcUsuario> getByNombreUsuario(String usuario) {
        return usuarioRepository.findByCorreo(usuario);
    }

    public boolean existsByNombreUsuario(String usuario) {
        return usuarioRepository.existsByCorreo(usuario);
    }

    public void save(NuevoUsuario nuevoUsuario) {

        TcUsuario usuario = new TcUsuario(
                nuevoUsuario.getNombre(),
                nuevoUsuario.getApellidoPaterno(),
                nuevoUsuario.getApellidoMaterno(),
                nuevoUsuario.getCorreo(),
                nuevoUsuario.getTelefono(),
                passwordEncoder.encode(nuevoUsuario.getContraseña()),
                nuevoUsuario.getClaveServidor(),
                nuevoUsuario.getIdDependencias(),
                nuevoUsuario.getCodigoVerificacion(),
                nuevoUsuario.getActivo());

        usuario.setRoles(asignaRol(nuevoUsuario));

        usuarioRepository.save(usuario);
    }

    public void actualizar(Long id, NuevoUsuario nuevoUsuario) {

        TcUsuario usuario = usuarioRepository.findById(id).get();

        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setApellidoPaterno(nuevoUsuario.getApellidoPaterno());
        usuario.setApellidoMaterno(nuevoUsuario.getApellidoMaterno());
        usuario.setCorreo(nuevoUsuario.getCorreo());
        usuario.setTelefono(nuevoUsuario.getTelefono());
        usuario.setClaveServidor(nuevoUsuario.getClaveServidor());
        usuario.setIdDependencias(nuevoUsuario.getIdDependencias());
        usuario.setCodigoVerificacion(nuevoUsuario.getCodigoVerificacion());
        usuario.setActivo(nuevoUsuario.getActivo());

        usuario.setRoles(asignaRol(nuevoUsuario));

        usuarioRepository.save(usuario);

    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    private Set<TcRol> asignaRol(NuevoUsuario nuevoUsuario) {
        Set<TcRol> roles = new HashSet<>();

        if (nuevoUsuario.getRoles() != null && !nuevoUsuario.getRoles().isEmpty()) {
            for (String rol : nuevoUsuario.getRoles()) {
                try {
                    RolNombre rolNombre = RolNombre.valueOf(rol.toUpperCase());
                    rolServiceImpl.getByRolNombre(rolNombre).ifPresent(roles::add);
                } catch (IllegalArgumentException e) {
                    System.err.println("Rol no encontrado: " + rol);
                }
            }
        }
        if (roles.isEmpty()) {
            rolServiceImpl.getByRolNombre(RolNombre.USUARIO).ifPresent(roles::add);
        }

        System.err.println("Roles asignados: " + roles);
        return roles;
    }

}