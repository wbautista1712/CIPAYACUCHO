/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Pago;
import com.cip.cipayacuchopagos.repository.PagoRepository;
import com.cip.cipayacuchopagos.service.PagoService;
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
public class PagoServiceImpl  extends GenericServiceImpl<Pago, Integer> implements PagoService {
    private static final Logger LOGGER = LogManager.getLogger(PagoServiceImpl.class);
    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public CrudRepository<Pago, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("PagoRepository");
        return pagoRepository;
    }
}
