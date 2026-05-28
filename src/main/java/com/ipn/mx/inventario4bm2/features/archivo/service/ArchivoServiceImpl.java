package com.ipn.mx.inventario4bm2.features.archivo.service;

import com.ipn.mx.inventario4bm2.core.entidades.Archivo;
import com.ipn.mx.inventario4bm2.features.archivo.repository.ArchivoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoDAO repository;

    @Override
    public Archivo guardarArchivoEnBaseDeDatos(MultipartFile archivo) throws IOException {
        String nombreArchivo = StringUtils.cleanPath(
                archivo.getOriginalFilename()
        );

        Archivo archivo1 = Archivo.builder()
                .nombreArchivo(nombreArchivo)
                .tipoArchivo(archivo.getContentType())
                .datosArchivo(archivo.getBytes())
                .build();

        return repository.save(archivo1);
    }

    @Override
    public Optional<Archivo> descargarArchivo(Long id) throws Exception {
        Optional<Archivo> archivoOp = repository.findById(id);
        if(archivoOp.isPresent()) {
            return archivoOp;
        }
        throw new Exception("El archivo no existe con ID: " + id);
    }

    @Override
    public List<Archivo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public void eliminarArchivo(Long id) {
        repository.deleteById(id);
    }
}