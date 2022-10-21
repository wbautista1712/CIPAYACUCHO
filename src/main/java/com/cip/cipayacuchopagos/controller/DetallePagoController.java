/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.DetallePago;
import com.cip.cipayacuchopagos.entity.Distrito;
import com.cip.cipayacuchopagos.service.DetallePagoService;
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

public class DetallePagoController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(DetallePagoController.class);

    @Autowired
    private DetallePagoService detallePagoService;


    @GetMapping(value = "/obtenerDetallePago")
    public ResponseEntity<List<DetallePago>> obtenerDetallePago() {
        LOGGER.info("obtenerDetallePago " );

        List<DetallePago> result = this.detallePagoService.getAll();
        LOGGER.info("result " + result.size());

        return ResponseEntity.ok().body(result);

    }

    @PostMapping(value = "/crearDetallePago")
    public ResponseEntity<?> crearDetallePago(@Valid @RequestBody DetallePago detallePago) {
        LOGGER.info("detallePago " + detallePago.toString());
        detallePagoService.save(detallePago);
        return new ResponseEntity<>("Insertado correctamente", HttpStatus.OK);
    }
}
