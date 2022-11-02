package com.cip.cipayacuchopagos.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author ARANGO
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "usuariorol", schema = "dbo")
public class UsuarioRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_usuariorol")
    @SequenceGenerator(name = "generator_usuariorol", sequenceName = "seq_usuariorol", allocationSize = 1)
    @Column(name = "idusuariorol")
    private Integer idUsuariorol;

    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "idrol")
    private Integer idRol;

}