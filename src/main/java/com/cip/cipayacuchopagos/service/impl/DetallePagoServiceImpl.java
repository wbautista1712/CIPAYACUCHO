/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.DetallePago;
import com.cip.cipayacuchopagos.repository.DetallePagoRepository;
import com.cip.cipayacuchopagos.service.DetallePagoService;
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
public class DetallePagoServiceImpl  extends GenericServiceImpl<DetallePago, Integer>  implements DetallePagoService {
    private static final Logger LOGGER = LogManager.getLogger(DetallePagoServiceImpl.class);

    @Autowired
    private DetallePagoRepository detallePagoRepository;

    @Override
    public CrudRepository<DetallePago, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("DetallePagoRepository");
        return detallePagoRepository;
    }
    
}
