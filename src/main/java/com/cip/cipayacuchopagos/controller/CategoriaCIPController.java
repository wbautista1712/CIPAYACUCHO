/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Capitulo;
import com.cip.cipayacuchopagos.entity.CategoriaCIP;
import com.cip.cipayacuchopagos.service.CategoriaCIPService;
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
public class CategoriaCIPController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(CategoriaCIPController.class);

    @Autowired
    private CategoriaCIPService categoriaCIPService;


    @GetMapping(value = "/obtenerCategoriaCIP")
    public ResponseEntity<List<CategoriaCIP>> obtenerCategoriaCIP() {
        LOGGER.info("obtenerCategoriaCIP " );

        List<CategoriaCIP> result = this.categoriaCIPService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);

    }


    @PostMapping(value = "/crearCategoriaCIP")
    public ResponseEntity<?> crearCategoriaCIP(@Valid @RequestBody CategoriaCIP categoriaCIP) {
        categoriaCIPService.save(categoriaCIP);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
