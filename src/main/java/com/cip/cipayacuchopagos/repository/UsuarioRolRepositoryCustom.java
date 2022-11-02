package com.cip.cipayacuchopagos.repository;


import com.cip.cipayacuchopagos.entity.UsuarioRol;

public interface UsuarioRolRepositoryCustom {
    public UsuarioRol findUsuarioRol(Integer idUsuario);

    public void updateUsuarioRol(Integer idUsuarioRol, Integer idRol);
}