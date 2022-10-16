/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.CategoriaCIP;
import com.cip.cipayacuchopagos.repository.CategoriaCIPRepository;
import com.cip.cipayacuchopagos.service.CategoriaCIPService;
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
public class CategoriaCIPServiceImpl  extends GenericServiceImpl<CategoriaCIP, Integer> implements CategoriaCIPService {
    private static final Logger LOGGER = LogManager.getLogger(CategoriaCIPServiceImpl.class);

    @Autowired
    private CategoriaCIPRepository categoriaCIPRepository;

    @Override
    public CrudRepository<CategoriaCIP, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("CrudRepository");
        return categoriaCIPRepository;
    }
}
