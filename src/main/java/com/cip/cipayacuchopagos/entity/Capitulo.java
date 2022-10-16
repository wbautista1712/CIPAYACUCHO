/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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
@Table(name = "Capitulo", schema = "dbo")
public class Capitulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCapitulo")
    private Integer idCapitulo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;


}
