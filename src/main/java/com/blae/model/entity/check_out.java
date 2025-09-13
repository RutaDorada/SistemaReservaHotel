package com.blae.model.entity;
import com.blae.model.enums.EstadoDevolucion;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "check_out")
public class check_out {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkout")
    private Integer idCheckout;

    // Relación con Reserva
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reserva", nullable = false)
    private reserva reserva;

    @Column(name = "fecha", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    // Relación con Personal que realiza el check-out
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "realizado_por")
    private personal realizadoPor;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_devolucion", nullable = false)
    private EstadoDevolucion estadoDevolucion;

    @Lob
    @Column(name = "descripcion_devolucion", columnDefinition = "TEXT")
    private String descripcionDevolucion;
}
