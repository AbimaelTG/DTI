package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.security.model.TcUsuario;
import com.api.security.repository.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TcUsuario guardar(TcUsuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public TcUsuario actualizar(Long id, TcUsuario usuario) {

        TcUsuario usuarioDB = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioDB.setNombre(usuario.getNombre());
        usuarioDB.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDB.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioDB.setCorreo(usuario.getCorreo());
        usuarioDB.setTelefono(usuario.getTelefono());
        usuarioDB.setClaveServidor(usuario.getClaveServidor());
        usuarioDB.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioDB.setIdDependencia(usuario.getIdDependencia());
        usuarioDB.setCodigoVerificacion(usuario.getCodigoVerificacion());
        usuarioDB.setActivo(usuario.getActivo());
        usuarioDB.setRoles(usuario.getRoles());

        return usuarioRepository.save(usuarioDB);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public TcUsuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<TcUsuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public TcUsuario buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null);
    }

    @Override
    public boolean existeCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    // 🔥 MÉTODOS QUE FALTABAN

    @Override
    public Optional<TcUsuario> getByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }
}
