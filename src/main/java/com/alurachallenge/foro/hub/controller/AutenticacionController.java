package com.alurachallenge.foro.hub.controller;


import com.alurachallenge.foro.hub.domain.usuario.DatosAutenticacionUsuario;
import com.alurachallenge.foro.hub.domain.usuario.Usuario;
import com.alurachallenge.foro.hub.infra.security.DatosJWTToken;
import com.alurachallenge.foro.hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario usuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.correo(),usuario.clave());
//        authenticationManager.authenticate(authToken);
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
