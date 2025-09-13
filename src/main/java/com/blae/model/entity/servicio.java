package com.blae.model.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
@Data
public class servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "nombre_servicio", nullable = false, length = 100)
    private String nombreServicio;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @Column(name ="precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

}
