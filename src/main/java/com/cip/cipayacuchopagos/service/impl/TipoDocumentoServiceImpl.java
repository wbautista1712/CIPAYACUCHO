/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.TipoDocumento;
import com.cip.cipayacuchopagos.repository.TipoDocumentoRepository;
import com.cip.cipayacuchopagos.service.TipoDocumentoService;
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
public class TipoDocumentoServiceImpl  extends GenericServiceImpl<TipoDocumento, Integer> implements TipoDocumentoService {
    private static final Logger LOGGER = LogManager.getLogger(TipoDocumentoServiceImpl.class);

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public CrudRepository<TipoDocumento, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("TipoDocumentoRepository");
        return tipoDocumentoRepository;
    }
}
