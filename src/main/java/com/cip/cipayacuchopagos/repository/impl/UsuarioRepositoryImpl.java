/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.repository.impl;

import com.cip.cipayacuchopagos.dto.UsuarioDto;
import com.cip.cipayacuchopagos.entity.Usuario;
import com.cip.cipayacuchopagos.repository.UsuarioRepositoryCustom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Arango
 */
@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
    private static final Logger LOGGER = LogManager.getLogger(UsuarioRepositoryImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Integer saveUsuario(Usuario usuario) throws SQLException {
        LOGGER.info(this.getClass().getName() + "." + new Exception().getStackTrace()[0].getMethodName());
        Integer rpta = null;

        DataSource ds = jdbcTemplate.getDataSource();
        Connection conn = null;
        CallableStatement csmt = null;

        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            csmt = conn.prepareCall("{call dbo.uspInsertarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");


            csmt.setString(1, usuario.getAppaterno().toUpperCase());
            csmt.setString(2, usuario.getApmaterno().toUpperCase());
            csmt.setString(3, usuario.getNombres().toUpperCase());
            csmt.setInt(4, usuario.getIdTipoDocumento());
            csmt.setString(5, usuario.getUsername());
            csmt.setString(6, usuario.getEmail());
            csmt.setString(7, usuario.getCelular());
            csmt.setString(8, usuario.getDireccion());
            csmt.setString(9, usuario.getPassword());
            csmt.setInt(10, usuario.getIddistrito());
            csmt.setInt(11, usuario.getIdcategoriacip());
            csmt.setInt(12, usuario.getIdespecialidad());
            csmt.setBoolean(13, usuario.isEstado());
            csmt.registerOutParameter(14, java.sql.Types.INTEGER);


            csmt.execute();
            rpta = csmt.getInt(14);
            LOGGER.info("GRABANDO STORED PROCEDURE");
            LOGGER.info("DATOS SALIDA dbo.uspInsertarUsuario ---> RESULTADO: " + rpta);

            if (rpta >= 1) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (Exception ex) {
            conn.rollback();
            ex.printStackTrace();
            LOGGER.error("Error: ", ex);
            return rpta;
        } finally {
            csmt.close();
            conn.close();
        }
        return rpta;
    }

    public void updateUsuario(Usuario usuario) {
        LOGGER.info("getAppaterno "+   usuario.getAppaterno());
        LOGGER.info("getApmaterno "+   usuario.getApmaterno());
		/*  this.jdbcTemplate.update(
	                " UPDATE  dbo.usuario x  set x.apPaterno  = ? , "
	                + " x.apMaterno  =  ? , x.nombres  =  ? "
	                + " WHERE  x.idUsuario =  ? ",
	                usuario.getAppaterno(), usuario.getApmaterno(),  usuario.getNombres(), usuario.getIdusuario());
		  */
        String sql = " UPDATE  dbo.usuario x  set x.apPaterno  = ? , "
                + " x.apMaterno  =  ? , x.nombres  =  ? "
                + " WHERE  x.idUsuario =  ? ";

        jdbcTemplate.update(sql,
                usuario.getAppaterno(),
                usuario.getApmaterno(),
                usuario.getNombres(),  usuario.getIdusuario());
    }

    public   List<UsuarioDto> getUsuarioRol(){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT U.idUsuario,U.apPaterno, U.apMaterno, U.nombres, U.email, U.username, R.idRol, R.nombreRol "
                + "FROM dbo.usuario U "
                + "INNER JOIN dbo.usuariorol UR ON U.idusuario=UR.idusuario "
                + "INNER JOIN dbo.rol R ON UR.idrol=R.idrol ");
        LOGGER.info(sb.toString());

        List<UsuarioDto> customers = jdbcTemplate.query(
                sb.toString(),
                new BeanPropertyRowMapper(UsuarioDto.class));

        return customers;
    }
}
