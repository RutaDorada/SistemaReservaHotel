package com.blae.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class ReservaServicioId implements Serializable {
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "id_servicio")
    private Integer idServicio;
}