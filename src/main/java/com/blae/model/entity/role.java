package com.blae.model.entity;
import com.blae.model.enums.Rol;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private Rol nombre;
}
