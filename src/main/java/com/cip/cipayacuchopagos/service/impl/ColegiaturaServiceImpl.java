/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Colegiatura;
import com.cip.cipayacuchopagos.repository.ColegiaturaRepository;
import com.cip.cipayacuchopagos.service.ColegiaturaService;
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

public class ColegiaturaServiceImpl  extends GenericServiceImpl<Colegiatura, Integer> implements ColegiaturaService {


    private static final Logger LOGGER = LogManager.getLogger(ColegiaturaServiceImpl.class);
    @Autowired
    private ColegiaturaRepository colegiaturaRepository;

    @Override
    public CrudRepository<Colegiatura, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("ColegiaturaRepository");
        return colegiaturaRepository;
    }
}
