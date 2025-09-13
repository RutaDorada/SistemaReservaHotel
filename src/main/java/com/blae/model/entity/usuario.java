package com.blae.model.entity;

import com.blae.model.enums.Rol;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name="nombre", nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(name="email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name="telefono", length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol; // cliente, recepcionista, admin

    @Column(name="contrasena",nullable = false, length = 255)
    private String contrasena;

}
