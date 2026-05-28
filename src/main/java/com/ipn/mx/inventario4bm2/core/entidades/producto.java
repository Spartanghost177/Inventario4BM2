package com.ipn.mx.inventario4bm2.core.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idProducto;
    @Column(length = 50, nullable = false)
    private String nombreProducto;
    @Column(length = 100, nullable = false)
    private String descripcionProducto;
    @Column(nullable = false)
    private double precioProducto;
    @Column(nullable = false)
    private int existencia;
    @Column(name = "create_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate createAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria", nullable = false)
    private categoria categoria;
}