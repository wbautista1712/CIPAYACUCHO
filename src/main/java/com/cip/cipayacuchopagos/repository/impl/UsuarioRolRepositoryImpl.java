package com.cip.cipayacuchopagos.repository.impl;


import com.cip.cipayacuchopagos.entity.UsuarioRol;
import com.cip.cipayacuchopagos.repository.UsuarioRolRepositoryCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Repository
@Transactional
public class UsuarioRolRepositoryImpl implements UsuarioRolRepositoryCustom {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioRolRepositoryImpl.class);


    private EntityManager em;

    @Override
    public UsuarioRol findUsuarioRol(Integer idUsuario) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM dbo.usuariorol x WHERE x.idUsuario = :idUsuario ");

        LOGGER.info(sb.toString());
        Query q = this.em.createNativeQuery(sb.toString(), UsuarioRol.class);
        q.setParameter("idUsuario", idUsuario);
        return (UsuarioRol) q.getSingleResult();
    }

    public void updateUsuarioRol(Integer idUsuarioRol, Integer idRol) {
       /* this.em.createNativeQuery(
                        " UPDATE db.usuariorol x  set x.idRol = :idRol WHERE  x.idUsuariorol  = :idUsuarioRol ")
                .setParameter(1, idRol).setParameter(2, idUsuarioRol).executeUpdate();
*/

        Query query = em.createNativeQuery(  "UPDATE db.usuariorol x  set x.idRol = :idRol WHERE  x.idUsuariorol  = :idUsuarioRol ");
        query.setParameter("idRol", idRol);
        query.setParameter("idUsuarioRol", idUsuarioRol);
        query.executeUpdate();
    }

}