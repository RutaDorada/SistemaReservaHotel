package com.blae.model.entity;

import com.blae.model.enums.Rol;
import jakarta.persistence.*;
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

    @Column(name="apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name="email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name="telefono", length = 20)
    private String telefono;

    @Column(name="contrasena", nullable = false, length = 255)
    private String contrasena;

    // Relación con la tabla Roles
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", nullable = false)
    private role rol;
}
