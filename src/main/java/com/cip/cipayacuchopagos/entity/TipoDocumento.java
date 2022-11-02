/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
@Table(name = "Tipodocumento", schema = "dbo")

public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_TipoDocumento")
    @SequenceGenerator(name = "generator_TipoDocumento", sequenceName = "seq_Comprobante_Pago", allocationSize = 1)
    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

}
