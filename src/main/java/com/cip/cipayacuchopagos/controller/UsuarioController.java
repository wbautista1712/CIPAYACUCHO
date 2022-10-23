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
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Arango
 */

@RestController
@RequestMapping("/api/seguridad")
@CrossOrigin(origins = "*")
public class UsuarioController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);
    @Autowired
    private UsuarioService usuarioService;




    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
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


    @GetMapping("/usuarios")
    public List<Usuario> index() {
        LOGGER.info("UsuarioController ");
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/page/{page}")
    public Page<Usuario> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return usuarioService.findAll(pageable);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuarioService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (usuario == null) {
            response.put("mensaje", "El Usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }



}
