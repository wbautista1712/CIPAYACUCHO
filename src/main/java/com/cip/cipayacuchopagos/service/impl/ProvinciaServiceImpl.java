/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Provincia;
import com.cip.cipayacuchopagos.repository.ProvinciaRepository;
import com.cip.cipayacuchopagos.service.ProvinciaService;
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

public class ProvinciaServiceImpl  extends GenericServiceImpl<Provincia, Integer> implements ProvinciaService {
    private static final Logger LOGGER = LogManager.getLogger(ProvinciaServiceImpl.class);
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public CrudRepository<Provincia, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("ProvinciaRepository");
        return provinciaRepository;
    }
}
