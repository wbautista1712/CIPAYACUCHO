/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.ConceptoPago;
import com.cip.cipayacuchopagos.entity.Distrito;
import com.cip.cipayacuchopagos.service.ConceptoPagoService;
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

public class ConceptoPagoController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(ConceptoPagoController.class);
    @Autowired
    private ConceptoPagoService conceptoPagoService;


    @GetMapping(value = "/obtenerConceptoPago")
    public ResponseEntity<List<ConceptoPago>> obtenerConceptoPago() {
        LOGGER.info("obtenerConceptoPago " );

        List<ConceptoPago> result = this.conceptoPagoService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);

    }

    @PostMapping(value = "/crearConceptoPago")
    public ResponseEntity<?> crearConceptoPago(@Valid @RequestBody ConceptoPago conceptoPago) {
        LOGGER.info("crearConceptoPago " +conceptoPago.toString());


        conceptoPagoService.save(conceptoPago);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
