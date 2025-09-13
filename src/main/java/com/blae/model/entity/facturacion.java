package com.blae.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "facturacion")
public class facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    // Relación uno a uno con Pago
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pago", nullable = false)
    private pago pago;

    @Column(name = "numero_factura", nullable = false, unique = true, length = 50)
    private String numeroFactura;

    @Column(name = "fecha_emision", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaEmision;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
