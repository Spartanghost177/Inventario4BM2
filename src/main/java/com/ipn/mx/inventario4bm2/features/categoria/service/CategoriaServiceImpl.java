package com.ipn.mx.inventario4bm2.features.categoria.service;

import com.ipn.mx.inventario4bm2.core.entidades.categoria;
import com.ipn.mx.inventario4bm2.features.categoria.repository.categoriaDAO;
import com.ipn.mx.inventario4bm2.features.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private categoriaDAO categoriaDAO;

    @Autowired
    private EmailService emailService;

    @Override
    public List<categoria> findAll(){
        return categoriaDAO.findAll();
    }

    @Override
    public categoria findById(Long id){
        return categoriaDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
    }

    @Override
    public categoria save(categoria categoria){
        categoria c = categoriaDAO.save(categoria);
        emailService.enviarCorreo(
                "yoshuamax@gmail.com",
                "Nueva categoría creada",
                "Se creó la categoría: " + c.getNombreCategoria() +
                        "\nDescripción: " + c.getDescripcionCategoria() +
                        "\nFecha: " + c.getCreateAt()
        );
        return c;
    }

    @Override
    public void deleteById(Long id){
        categoriaDAO.deleteById(id);
    }
}