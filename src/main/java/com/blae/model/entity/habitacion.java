package com.blae.model.entity;
import com.blae.model.enums.Tipo;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="habitaciones")

public class habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "numero_habitacion", nullable = false, unique = true)
    private Integer numeroHabitacion;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_habitacion")
    private Tipo tipo; // simple, doble, suite

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "precio_noche", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioNoche;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;


}
