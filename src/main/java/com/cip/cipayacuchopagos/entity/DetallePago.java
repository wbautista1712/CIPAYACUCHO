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
@Table(name = "Detallepago", schema = "dbo")

public class DetallePago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Detalle_Pago")
    @SequenceGenerator(name = "generator_Detalle_Pago", sequenceName = "seq_Detalle_Pago", allocationSize = 1)
    @Column(name = "iddetallepago")
    private Integer iddetallepago;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "idconceptopago")
    private Integer idConceptoPago;

    @Column(name = "idpago")
    private Integer idpago;
}
