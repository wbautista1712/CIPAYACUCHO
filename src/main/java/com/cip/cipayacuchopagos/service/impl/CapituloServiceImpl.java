/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Capitulo;
import com.cip.cipayacuchopagos.repository.CapituloRepository;
import com.cip.cipayacuchopagos.service.CapituloService;
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
public class CapituloServiceImpl  extends GenericServiceImpl<Capitulo, Integer> implements CapituloService {
    private static final Logger LOGGER = LogManager.getLogger(CapituloServiceImpl.class);

    @Autowired
    private CapituloRepository capituloRepository;

    @Override
    public CrudRepository<Capitulo, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("CapituloRepository");
        return capituloRepository;
    }
}
