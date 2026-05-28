package com.ipn.mx.inventario4bm2.core.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")

public class categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCategoria;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    @Column(length = 50, nullable = false)
    private String nombreCategoria;
    @Column(length = 100, nullable = false)
    private String descripcionCategoria;
    @Column(name = "Create_at", nullable = true) //Como es una fecha, no tiene una restriccion de longitud de cadena
    private LocalDate createAt;
    //Si interfiere el nombre de atributo con la clase y la clase, debemos poner name

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<producto> productos = new HashSet<>();
}
