package com.blae.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva_servicio")
public class reserva_servicio {

    @EmbeddedId
    private ReservaServicioId id;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "id_reserva")
    private reserva reserva;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "id_servicio")
    private servicio servicio;

    @Column(name="cantidad", nullable = false)
    private Integer cantidad = 1;
}