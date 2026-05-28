package com.ipn.mx.inventario4bm2.features.producto.service;

import com.ipn.mx.inventario4bm2.core.entidades.producto;

import java.util.List;

public interface productoService{

    List<producto> findAll();
    producto findById(Long id);
    producto save(producto producto);
    void deleteById(Long id);

}
