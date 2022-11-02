/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.entity.UsuarioRol;
import com.cip.cipayacuchopagos.service.UsuarioRolService;
import com.cip.cipayacuchopagos.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    private UsuarioRolService usuarioRolService;

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
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario, BindingResult result, @RequestParam Integer idRol) throws SQLException {
        LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());
        passwordEncoder = new BCryptPasswordEncoder();
        Usuario usuarioNew = null;
        Map<String, Object> response = new HashMap<>();
        Integer idUser = null;
        UsuarioRol usuarioRol = new UsuarioRol();
        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            LOGGER.info("crearUsuario idRol::.. "+idRol );
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            //usuarioNew = usuarioService.save(usuario);// cambiar aqui

            idUser = this.usuarioService.saveUsuario(usuario).intValue();
            LOGGER.info("idRol ===>> "+idRol);
            LOGGER.info("idUser ===>> "+idUser);
            usuarioRol.setIdRol(idRol);
            usuarioRol.setIdUsuario(idUser);
            this.usuarioRolService.save(usuarioRol);
            LOGGER.info("fin::.. " );
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido creado con éxito!");
        // response.put("cliente", usuarioNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @GetMapping("/usuarios")
    public List<Usuario> index() {
        LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/page/{page}")
    public Page<Usuario> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return usuarioService.findAll(pageable);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());
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
