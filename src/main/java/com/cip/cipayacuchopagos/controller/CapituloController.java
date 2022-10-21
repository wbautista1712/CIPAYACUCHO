/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Capitulo;
import com.cip.cipayacuchopagos.service.CapituloService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 *
 * @author Arango
 */

@RestController
@RequestMapping(path = "/api/cipayacucho")
@CrossOrigin(origins = "*")
public class CapituloController   {
    private static final Logger LOGGER = LogManager.getLogger(CapituloController.class);

    @Autowired
    private CapituloService capituloService;



    @GetMapping(value = "/obtenerCapitulo")
    public ResponseEntity<List<Capitulo>> obtenerCapitulo() {
        LOGGER.info(".. ::obtenerCapitulo::.." );

        List<Capitulo> result = this.capituloService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/crearCapitulo")
    public ResponseEntity<?> crearCapitulo(@Valid @RequestBody Capitulo capitulo) {
        capituloService.save(capitulo);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
