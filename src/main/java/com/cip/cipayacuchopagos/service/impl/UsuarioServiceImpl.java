/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.repository.UsuarioRepository;
import com.cip.cipayacuchopagos.service.UsuarioService;
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
public class UsuarioServiceImpl  extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {
    private static final Logger LOGGER = LogManager.getLogger(UsuarioServiceImpl.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        // TODO Auto-generated method stub
        LOGGER.info("UsuarioRepository");
        return usuarioRepository;
    }
}
