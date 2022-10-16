/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Departamento;
import com.cip.cipayacuchopagos.repository.DepartamentoRepository;
import com.cip.cipayacuchopagos.service.DepartamentoService;
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

public class DepartamentoServiceImpl   extends GenericServiceImpl<Departamento, Integer> implements DepartamentoService {
    private static final Logger LOGGER = LogManager.getLogger(DepartamentoServiceImpl.class);
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public CrudRepository<Departamento, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("DepartamentoRepository");
        return departamentoRepository;
    }
}
