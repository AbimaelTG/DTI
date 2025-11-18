package com.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.security.model.TcUser;
import com.api.security.model.MainUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserServiceImp usuarioServiceImp;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== UserDetailsServiceImpl ===");
        System.out.println("Buscando usuario por correo: " + username);
        
        // Usa getByCorreo() que es más claro
        TcUser usuario = usuarioServiceImp.getByCorreo(username)
                .orElseThrow(() -> {
                    System.out.println("Usuario no encontrado: " + username);
                    return new UsernameNotFoundException("Usuario no encontrado: " + username);
                });
        
        System.out.println("Usuario encontrado: " + usuario.getCorreo());
        return MainUser.build(usuario);
    }
}