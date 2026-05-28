package com.ipn.mx.inventario4bm2;

import com.ipn.mx.inventario4bm2.core.entidades.categoria;
import com.ipn.mx.inventario4bm2.core.entidades.producto;
import com.ipn.mx.inventario4bm2.features.categoria.repository.categoriaDAO;
import com.ipn.mx.inventario4bm2.features.producto.repository.productoDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Inventario4Bm2Application implements CommandLineRunner {

    @Autowired
    private categoriaDAO daoC;
    @Autowired
    private productoDAO daoP;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        //Esta sección es para categoria
//        System.out.println("Creando categoria...");
//        categoria categoria = new categoria();
//        categoria.setIdCategoria(2L);
//        categoria.setIdCategoria(1L);
//        categoria.setNombreCategoria("ELECTRONICA");
//        categoria.setDescripcionCategoria("Articulos DEFEFESFSFSE");
//        categoria.setCreateAt(LocalDate.now()); // ✅ IMPORTANTE: Asignar la fecha actual
//
//        daoC.save(categoria);
//        daoC.save(categoria);
//        System.out.println(daoC.findById(3L));
//        System.out.println(daoC.findAll());
//        dao.deleteById(categoria.getIdCategoria());


        //Esta sección es para productos
        System.out.println("Creando producto...");
//        producto producto = new producto();
//        producto.setIdProducto(2L);
//        producto.setIdProducto(1L);
//        producto.setNombreProducto("ELECTRONICA");
//        producto.setDescripcionProducto("Articulos DEFEFESFSFSE");
//        producto.setCreateAt(LocalDate.now()); // ✅ IMPORTANTE: Asignar la fecha actual

//        daoP.save(producto);
//        daoP.save(producto);
//        System.out.println(daoP.findById(3L));
        System.out.println(daoP.findAll());
//        daoP.deleteById(producto.setIdProducto());

    }


    public static void main(String[] args) {
        SpringApplication.run(Inventario4Bm2Application.class, args);
    }
}




