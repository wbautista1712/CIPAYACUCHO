/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Arango
 */

@RestController
@RequestMapping(path = "/api/cipayacucho")
@CrossOrigin(origins = "*")
public class UsuarioController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/obtenerUsuario")
    public ResponseEntity<List<Usuario>> obtenerUsuario() {
        LOGGER.info("obtenerTipoDocumento " );

        List<Usuario> result = this.usuarioService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);

    }

    @PostMapping(value = "/crearUsuario")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        LOGGER.info("crearUsuario " + usuario.toString());
        usuarioService.save(usuario);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
