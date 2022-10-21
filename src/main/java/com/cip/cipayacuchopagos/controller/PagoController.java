/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Pago;
import com.cip.cipayacuchopagos.service.PagoService;
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

public class PagoController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(PagoController.class);
    @Autowired
    private PagoService pagoService;

    @GetMapping(value = "/obtenerPago")
    public ResponseEntity<List<Pago>> obtenerPago() {
        LOGGER.info("obtenerPago " );
        List<Pago> result = this.pagoService.getAll();
        LOGGER.info("result " + result.size());
        return ResponseEntity.ok().body(result);
    }
}
