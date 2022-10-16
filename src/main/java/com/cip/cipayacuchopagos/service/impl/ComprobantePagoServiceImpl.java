/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.ComprobantePago;
import com.cip.cipayacuchopagos.repository.ComprobantePagoRepository;
import com.cip.cipayacuchopagos.service.ComprobantePagoService;
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

public class ComprobantePagoServiceImpl  extends GenericServiceImpl<ComprobantePago, Integer>  implements ComprobantePagoService {

    private static final Logger LOGGER = LogManager.getLogger(ComprobantePagoServiceImpl.class);
    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    @Override
    public CrudRepository<ComprobantePago, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("ComprobantePagoRepository");
        return comprobantePagoRepository;
    }
}
