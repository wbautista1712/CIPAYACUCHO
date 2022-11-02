/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service;

import com.cip.cipayacuchopagos.dto.UsuarioDto;
import com.cip.cipayacuchopagos.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Arango
 */

public interface UsuarioService extends GenericService<Usuario, Integer>   {

    public List<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);
    public Usuario findByUsername(String username);

    public Usuario findById(Long id);

    public Usuario save(Usuario usuario);

    public void delete(Long id);

    public Integer saveUsuario(Usuario usuario) throws SQLException;

    public void updateUsuario(Usuario usuario);

    public   List<UsuarioDto> getUsuarioRol();
    
}
