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
@Table(name = "Colegiatura", schema = "dbo")

public class Colegiatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Colegiatura")
    @SequenceGenerator(name = "generator_Colegiatura", sequenceName = "seq_Colegiatura", allocationSize = 1)
    @Column(name = "idcolegiatura")
    private Integer idcolegiatura;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "idusuario")
    private Integer idusuario;
}
