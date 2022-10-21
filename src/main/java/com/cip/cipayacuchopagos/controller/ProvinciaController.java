/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Provincia;
import com.cip.cipayacuchopagos.service.ProvinciaService;
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

public class ProvinciaController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(ProvinciaController.class);
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value = "/obtenerProvincia")
    public ResponseEntity<List<Provincia>> obtenerProvincia() {
        LOGGER.info("obtenerProvincia " );

        List<Provincia> result = this.provinciaService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);

    }

    @PostMapping(value = "/crearProvincia")
    public ResponseEntity<?> crearDepartamento(@Valid @RequestBody Provincia provincia) {
        LOGGER.info("departamento " + provincia.toString());
        provinciaService.save(provincia);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
