/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Distrito;
import com.cip.cipayacuchopagos.repository.DistritoRepository;
import com.cip.cipayacuchopagos.service.DistritoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author Arango
 */
@Service

public class DistritoServiceImpl   extends GenericServiceImpl<Distrito, Integer> implements DistritoService {
    private static final Logger LOGGER = LogManager.getLogger(DistritoServiceImpl.class);
    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public CrudRepository<Distrito, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("DistritoRepository");
        return distritoRepository;
    }
}
