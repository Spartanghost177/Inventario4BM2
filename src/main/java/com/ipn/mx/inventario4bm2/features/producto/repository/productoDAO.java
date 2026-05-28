package com.ipn.mx.inventario4bm2.features.producto.repository;

import com.ipn.mx.inventario4bm2.core.entidades.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoDAO extends JpaRepository<producto, Long> {
}
