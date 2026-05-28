package com.ipn.mx.inventario4bm2.features.categoria.service;

import com.ipn.mx.inventario4bm2.core.entidades.categoria;

import java.util.List;

public interface CategoriaService {

    List<categoria> findAll();
    categoria findById(Long id);
    categoria save(categoria categoria);
    void deleteById(Long id);
}