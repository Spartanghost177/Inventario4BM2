package com.ipn.mx.inventario4bm2.features.categoria.controller;

import com.ipn.mx.inventario4bm2.core.entidades.categoria;
import com.ipn.mx.inventario4bm2.features.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    @ResponseStatus(HttpStatus.OK)
    public List<categoria> findAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public categoria findById(@PathVariable Long id){
        return categoriaService.findById(id);
    }

    @PostMapping("/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public categoria create(@RequestBody categoria categoria){

        return categoriaService.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public categoria update(
            @RequestBody categoria categoria,
            @PathVariable Long id){
        categoria c = categoriaService.findById(id);
        c.setNombreCategoria(categoria.getNombreCategoria());
        c.setDescripcionCategoria(categoria.getDescripcionCategoria());
        c.setCreateAt(categoria.getCreateAt());
        return categoriaService.save(c);
    }

    @DeleteMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoriaService.deleteById(id);
    }
}