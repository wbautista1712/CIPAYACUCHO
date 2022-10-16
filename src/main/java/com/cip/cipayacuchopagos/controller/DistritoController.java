/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Distrito;
import com.cip.cipayacuchopagos.service.DistritoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Arango
 */

@RestController
@RequestMapping(path = "/api/wmsmysql")
@CrossOrigin(origins = "*")

public class DistritoController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(DistritoController.class);
    @Autowired
    private DistritoService distritoService;


    @GetMapping(value = "/obtenerDistrito")
    public ResponseEntity<List<Distrito>> obtenerDistrito() {
        LOGGER.info("obtenerDistrito " );

        List<Distrito> result = this.distritoService.getAll();
        LOGGER.info("result " + result.size());



        return ResponseEntity.ok().body(result);

    }
}
