/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.repository;

import com.cip.cipayacuchopagos.dto.UsuarioDto;
import com.cip.cipayacuchopagos.entity.Usuario;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Arango
 */

public interface UsuarioRepositoryCustom {

    public Integer saveUsuario(Usuario usuario) 	throws SQLException;
    public void updateUsuario(Usuario usuario);

    public List<UsuarioDto> getUsuarioRol();
    
}
