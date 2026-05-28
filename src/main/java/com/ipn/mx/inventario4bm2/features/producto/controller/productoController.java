package com.ipn.mx.inventario4bm2.features.producto.controller;


import com.ipn.mx.inventario4bm2.core.entidades.producto;
import com.ipn.mx.inventario4bm2.core.entidades.producto;
import com.ipn.mx.inventario4bm2.features.producto.service.productoService;
import com.ipn.mx.inventario4bm2.features.producto.service.productoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/productos")

public class productoController {
    @Autowired
    private productoService productoService;

    @GetMapping("/producto")
    @ResponseStatus(HttpStatus.OK)
    public List<producto> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public producto findById(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public producto create(@RequestBody producto producto){
        return productoService.save(producto);
    }

    @PutMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public producto update(
            @RequestBody producto producto,
            @PathVariable Long id){
        producto p = productoService.findById(id);
        if(p == null) return null;
        p.setNombreProducto(producto.getNombreProducto());
        p.setDescripcionProducto(producto.getDescripcionProducto());
        p.setPrecioProducto(producto.getPrecioProducto());
        p.setExistencia(producto.getExistencia());
        p.setCreateAt(producto.getCreateAt());
        p.setCategoria(producto.getCategoria());
        return productoService.save(p);
    }

    @DeleteMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productoService.deleteById(id);
    }
}

