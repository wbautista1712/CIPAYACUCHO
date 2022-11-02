/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.dto.UsuarioDto;
import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.repository.UsuarioRepository;
import com.cip.cipayacuchopagos.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author Arango
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService, UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Autowired
    private UsuarioRepository usuarioDao;


    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        // TODO Auto-generated method stub
        logger.info("TipoDocumentoRepository");
        return usuarioDao;
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByUsername(username);

        if(usuario == null) {
            logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombrerol()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());


        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEstado(), true, true, true, authorities);

    }

    @Override
    @Transactional(readOnly=true)
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
       // return usuarioDao.findAll(pageable);
        return null;
    }


    @Secured({"ROLE_ADMIN"})
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public Usuario get(Integer integer) {
        return null;
    }

    @Override
    @Secured({"ROLE_ADMIN"})
    public List<Usuario> getAll() {
        return null;
    }

    @Secured({"ROLE_ADMIN"})
    public Integer saveUsuario(Usuario usuario) throws SQLException {
        return usuarioDao.saveUsuario(usuario);
    }

    @Secured({"ROLE_ADMIN"})
    public void updateUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Secured({"ROLE_ADMIN"})
    public   List<UsuarioDto> getUsuarioRol(){
        return usuarioDao.getUsuarioRol();
    }
}
