/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.TipoDocumento;
import com.cip.cipayacuchopagos.service.TipoDocumentoService;
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
@RequestMapping(path = "/api/cipayacucho")
@CrossOrigin(origins = "*")
public class TipoDocumentoController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(TipoDocumentoController.class);

    @Autowired
    private TipoDocumentoService tipoDocumentoService;


    @GetMapping(value = "/obtenerTipoDocumento")
    public ResponseEntity< List<TipoDocumento>> obtenerTipoDocumento() {
        LOGGER.info("obtenerTipoDocumento " );

            List<TipoDocumento> result = this.tipoDocumentoService.getAll();
            LOGGER.info("result " + result.size());



        return ResponseEntity.ok().body(result);

    }


}
