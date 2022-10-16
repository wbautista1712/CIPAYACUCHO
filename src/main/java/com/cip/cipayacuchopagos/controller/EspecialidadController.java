/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.controller;

import com.cip.cipayacuchopagos.entity.Especialidad;
import com.cip.cipayacuchopagos.entity.TipoDocumento;
import com.cip.cipayacuchopagos.repository.impl.CapituloRepositoryImpl;
import com.cip.cipayacuchopagos.service.CapituloService;
import com.cip.cipayacuchopagos.service.EspecialidadService;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Arango
 */

@RestController
@RequestMapping(path = "/api/wmsmysql")
@CrossOrigin(origins = "*")

public class EspecialidadController implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(EspecialidadController.class);
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping(value = "/obtenerEspecialidad")
    public ResponseEntity<List<Especialidad>> obtenerEspecialidad() {
        LOGGER.info("obtenerEspecialidad " );

        List<Especialidad> result = this.especialidadService.getAll();
        LOGGER.info("result " + result.size());



        return ResponseEntity.ok().body(result);

    }
}
