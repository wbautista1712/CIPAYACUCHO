package com.cip.cipayacuchopagos.service;


import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.entity.UsuarioRol;

public interface UsuarioRolService extends GenericService<UsuarioRol, Integer>  {


    public UsuarioRol findById(int id);

    public UsuarioRol findUsuarioRol(Integer idUsuario);

    public void updateUsuarioRol(Integer idUsuarioRol, Integer idRol);
}