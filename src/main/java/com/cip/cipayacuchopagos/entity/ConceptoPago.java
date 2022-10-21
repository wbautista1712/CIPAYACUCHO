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
@Table(name = "Conceptopago", schema = "dbo")

public class ConceptoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Concepto_Pago")
    @SequenceGenerator(name = "generator_Concepto_Pago", sequenceName = "seq_Comprobante_Pago", allocationSize = 1)
    @Column(name = "idconceptopago")
    private Integer idConceptoPago;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechacreacion")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;

    @Basic(optional = false)
    @Column(name = "montounitario")
    private BigDecimal montounitario;
    @Basic(optional = false)
    @Column(name = "fechamodificacion")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;



    
}
