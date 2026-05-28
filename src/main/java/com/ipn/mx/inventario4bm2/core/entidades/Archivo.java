package com.ipn.mx.inventario4bm2.core.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "archivo")
public class Archivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArchivo;

    private String nombreArchivo;

    private String tipoArchivo;

    @Lob
    @Column(length = 16000000)
    private byte[] datosArchivo;
}