package com.cip.cipayacuchopagos.repository;

import com.cip.cipayacuchopagos.entity.UsuarioRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Integer>, UsuarioRolRepositoryCustom {

}