/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.repository.impl;

import com.cip.cipayacuchopagos.repository.CategoriaCIPRepositoryCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
/**
 *
 * @author Arango
 */
@Repository
@Transactional
public class CategoriaCIPRepositoryImpl implements CategoriaCIPRepositoryCustom {
    private static final Logger LOGGER = LogManager.getLogger(CategoriaCIPRepositoryImpl.class);


}
