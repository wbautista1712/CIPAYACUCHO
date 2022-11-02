/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cip.cipayacuchopagos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "Usuario", schema = "dbo")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_Usuario")
    @SequenceGenerator(name = "generator_Usuario", sequenceName = "seq_Usuario", allocationSize = 1)
    @Column(name = "idusuario")
    private Integer idusuario;

    @Basic(optional = false)
    @Column(name = "appaterno")
    private String appaterno;
    @Basic(optional = false)
    @Column(name = "apmaterno")
    private String apmaterno;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "nrodocumento")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;

    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    @Column(name = "iddistrito")
    private Integer iddistrito;

    @Column(name = "idcategoriacip")
    private Integer idcategoriacip;

    @Column(name = "idespecialidad")
    private Integer idespecialidad;

    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;


    @Column(name = "clave")
    private String password;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuariorol", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idrol"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "idusuario", "idrol" }) })
    private List<Rol> roles;
}
