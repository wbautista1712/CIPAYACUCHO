/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Pago")
    @SequenceGenerator(name = "generator_Pago", sequenceName = "seq_Pago", allocationSize = 1)
    @Column(name = "idpago")
    private Integer idpago;
    @Basic(optional = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Column(name = "fechapago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;

    @Basic(optional = false)
    @Column(name = "montototal")
    private BigDecimal montototal;
    @Basic(optional = false)
    @Column(name = "numeracion")
    private String numeracion;
    @Basic(optional = false)
    @Column(name = "codigoqr")
    private String codigoqr;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "idcomprobantepago")
    private Integer idcomprobantepago;
    @Column(name = "idusuario")
    private Integer idusuario;
}
