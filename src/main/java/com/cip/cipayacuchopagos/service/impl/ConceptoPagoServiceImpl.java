/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.ConceptoPago;
import com.cip.cipayacuchopagos.repository.ConceptoPagoRepository;
import com.cip.cipayacuchopagos.service.ConceptoPagoService;
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

public class ConceptoPagoServiceImpl  extends GenericServiceImpl<ConceptoPago, Integer>  implements ConceptoPagoService {


    private static final Logger LOGGER = LogManager.getLogger(ConceptoPagoServiceImpl.class);
    @Autowired
    private ConceptoPagoRepository conceptoPagoRepository;

    @Override
    public CrudRepository<ConceptoPago, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("ConceptoPagoRepository");
        return conceptoPagoRepository;
    }
}
