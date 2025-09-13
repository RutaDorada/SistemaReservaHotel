package com.blae.model.entity;
import com.blae.model.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "huespedes_temporales")
public class huesped_temporal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped_temp")
    private Integer idHuespedTemp;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "documento", length = 20)
    private String documento;

    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "creado_en", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creadoEn;

    // Relación con Personal que registró al huésped
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registrado_por", nullable = false)
    private personal registradoPor;
}
