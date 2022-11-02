package com.cip.cipayacuchopagos.service.impl;

import com.cip.cipayacuchopagos.entity.TipoDocumento;
import com.cip.cipayacuchopagos.entity.UsuarioRol;
import com.cip.cipayacuchopagos.repository.UsuarioRolRepository;
import com.cip.cipayacuchopagos.service.UsuarioRolService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl   extends GenericServiceImpl<UsuarioRol, Integer>  implements UsuarioRolService {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioRolServiceImpl.class);

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public CrudRepository<UsuarioRol, Integer> getDao() {
        return usuarioRolRepository;
    }



    @Override
    public UsuarioRol findById(int id) {
        return usuarioRolRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioRol findUsuarioRol(Integer idUsuario) {
        return usuarioRolRepository.findUsuarioRol(idUsuario);
    }

    public void updateUsuarioRol(Integer idUsuarioRol, Integer idRol) {
        LOGGER.info("idUsuarioRol==>> "+idUsuarioRol);
        LOGGER.info("idRol==>> "+idRol);
        this.usuarioRolRepository.updateUsuarioRol(idUsuarioRol, idRol);
    }

}