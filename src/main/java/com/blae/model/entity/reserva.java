package com.blae.model.entity;
import com.blae.model.enums.Estado;
import com.blae.model.enums.EstadoReserva;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="reservas")
public class reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private habitacion habitacion;

    @CreationTimestamp
    @Column(name = "fecha_reserva", nullable = false)
    private LocalDateTime fechaReserva = LocalDateTime.now();

    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoReserva estado;

    @ManyToMany
    @JoinTable(
            name = "reserva_servicio",
            joinColumns = @JoinColumn(name = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private Set<servicio> servicios;
}
