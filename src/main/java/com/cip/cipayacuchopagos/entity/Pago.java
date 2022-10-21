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
import java.util.Collection;
import java.util.Date;

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
@Table(name = "Pago", schema = "dbo")

public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPago")
    private Integer idPago;
    @Basic(optional = false)
    @Column(name = "fechaPago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;

    @Basic(optional = false)
    @Column(name = "montoTotal")
    private BigDecimal montoTotal;
    @Basic(optional = false)
    @Column(name = "numeracion")
    private String numeracion;
    @Basic(optional = false)
    @Column(name = "codigoQR")
    private String codigoQR;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "idComprobantePago", referencedColumnName = "idComprobantePago")
    @ManyToOne(optional = false)
    private ComprobantePago idComprobantePago;


}
