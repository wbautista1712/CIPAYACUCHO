/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Arango
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "DetallePago", schema = "dbo")

public class DetallePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Pago")
    @SequenceGenerator(name = "generator_Pago", sequenceName = "seq_Comprobante_Pago", allocationSize = 1)
    @Column(name = "idDetallePago")
    private Integer idDetallePago;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;



    
}
