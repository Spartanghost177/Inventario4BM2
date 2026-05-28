package com.ipn.mx.inventario4bm2.features.archivo.repository;

import com.ipn.mx.inventario4bm2.core.entidades.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoDAO extends JpaRepository<Archivo, Long> {
}