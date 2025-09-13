package com.blae.model.entity;
import com.blae.model.enums.EstadoReserva;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name="reservas")
public class reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    // Relación opcional con Cliente (puede ser NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private cliente cliente;

    // Relación opcional con Huesped Temporal (puede ser NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_huesped_temp")
    private huesped_temporal huespedTemporal;

    // Relación con Habitacion
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private habitacion habitacion;

    @Column(name = "fecha_reserva", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaReserva;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "noches", nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer noches;

    // Campo calculado - solo lectura
    @Column(name = "check_out", insertable = false, updatable = false)
    private LocalDate checkOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoReserva estado;
}
