/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.repository;

import com.cip.cipayacuchopagos.entity.ConceptoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Arango
 */
@Repository
public interface ConceptoPagoRepository extends CrudRepository<ConceptoPago, Integer> , ConceptoPagoRepositoryCustom{



    
}
