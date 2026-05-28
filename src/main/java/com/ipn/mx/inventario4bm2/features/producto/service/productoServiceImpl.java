package com.ipn.mx.inventario4bm2.features.producto.service;

import com.ipn.mx.inventario4bm2.core.entidades.producto;
import com.ipn.mx.inventario4bm2.features.email.service.EmailService;
import com.ipn.mx.inventario4bm2.features.producto.repository.productoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class productoServiceImpl implements productoService {

    @Autowired
    private productoDAO dao;

    @Override
    public List<producto> findAll() {
        return dao.findAll();
    }

    @Override
    public producto findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Autowired
    private EmailService emailService;  // ← Agregar esto

    @Override
    public producto save(producto producto) {

        if (producto.getCreateAt() == null) {
            producto.setCreateAt(LocalDate.now());
        }
        producto p = dao.save(producto);

        // Enviar correo automático al crear
        emailService.enviarCorreo(
                "destinatario@gmail.com",  // ← El correo que quieras notificar
                "Nuevo producto creado",
                "Se creó el producto: " + p.getNombreProducto() +
                        "\nPrecio: $" + p.getPrecioProducto() +
                        "\nExistencia: " + p.getExistencia()
        );

        return p;
    }
}