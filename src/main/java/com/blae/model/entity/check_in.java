package com.blae.model.entity;

import com.blae.model.enums.EstadoEntrega;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "check_in")
public class check_in {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkin")
    private Integer idCheckin;

    // Relación con Reserva
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reserva", nullable = false)
    private reserva reserva;

    @Column(name = "fecha", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    // Relación con Personal que realiza el check-in
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "realizado_por")
    private personal realizadoPor;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_entrega", nullable = false)
    private EstadoEntrega estadoEntrega;

    @Lob
    @Column(name = "descripcion_entrega", columnDefinition = "TEXT")
    private String descripcionEntrega;
}
