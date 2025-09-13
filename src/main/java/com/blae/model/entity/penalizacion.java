package com.blae.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "penalizaciones")
public class penalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penalizacion")
    private Integer idPenalizacion;

    // Relación con CheckOut
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_checkout", nullable = false)
    private check_out checkOut;

    // Relación opcional con Pago (se llena cuando se paga la penalización)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    private pago pago;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Lob
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;
}
