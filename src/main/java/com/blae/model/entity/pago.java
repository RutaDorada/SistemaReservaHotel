package com.blae.model.entity;

import com.blae.model.enums.Estado;
import com.blae.model.enums.Metodopago;
import com.blae.model.enums.Tipopago;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagos")
public class pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private reserva reserva;

    @Column(name="monto",nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private Metodopago metodoPago; // tarjeta, efectivo, transferencia

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pago")
    private Tipopago tipo;

    @CreationTimestamp
    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fechaPago = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado; // pagado, pendiente, reembolsado
}