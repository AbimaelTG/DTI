package com.api.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.enums.RolNombre;
import com.api.security.dto.User;
import com.api.security.model.TcRol;
import com.api.security.model.TcUser;
import com.api.security.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    public UserRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolServiceImpl rolServiceImpl;

    @Override
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Optional<TcUser> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<TcUser> getByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public Optional<TcUser> getByNombreUsuario(String usuario) {
        return usuarioRepository.findByCorreo(usuario);
    }

    @Override
    public boolean existsByNombreUsuario(String usuario) {
        return usuarioRepository.existsByCorreo(usuario);
    }

    @Override
    public void save(User nuevoUsuario) {
        TcUser usuario = new TcUser(
            nuevoUsuario.getNombre(),
            nuevoUsuario.getApellidoPaterno(),
            nuevoUsuario.getApellidoMaterno(),
            nuevoUsuario.getCorreo(),
            nuevoUsuario.getTelefono(),
            passwordEncoder.encode(nuevoUsuario.getContrasena()),
            nuevoUsuario.getClaveServidor(),
            nuevoUsuario.getIdDependencia(),
            nuevoUsuario.getCodigoVerificacion(),
            nuevoUsuario.getActivo()
        );

        usuario.setRoles(asignaRol(nuevoUsuario));

        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Long id, User nuevoUsuario) {
        TcUser usuario = usuarioRepository.findById(id).get();

        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setApellidoPaterno(nuevoUsuario.getApellidoPaterno());
        usuario.setApellidoMaterno(nuevoUsuario.getApellidoMaterno());
        usuario.setCorreo(nuevoUsuario.getCorreo());
        usuario.setTelefono(nuevoUsuario.getTelefono());
        usuario.setClaveServidor(nuevoUsuario.getClaveServidor());
        usuario.setIdDependencia(nuevoUsuario.getIdDependencia());
        usuario.setCodigoVerificacion(nuevoUsuario.getCodigoVerificacion());
        usuario.setActivo(nuevoUsuario.getActivo());

        usuario.setRoles(asignaRol(nuevoUsuario));

        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        usuarioRepository.deleteById(id);
    }

    private Set<TcRol> asignaRol(User nuevoUsuario) {
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

        return roles;
    }
}


