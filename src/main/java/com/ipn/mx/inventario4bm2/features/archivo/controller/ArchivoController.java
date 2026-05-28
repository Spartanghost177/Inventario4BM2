package com.ipn.mx.inventario4bm2.features.archivo.controller;


import com.ipn.mx.inventario4bm2.core.entidades.Archivo;
import com.ipn.mx.inventario4bm2.features.archivo.DTO.RespuestaDTO;
import com.ipn.mx.inventario4bm2.features.archivo.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiArchivo/archivo")
public class ArchivoController {

    @Autowired
    private ArchivoService service;

    @PostMapping("/subirArchivo")
    public ResponseEntity<RespuestaDTO> subirArchivo(@RequestParam("archivo") MultipartFile archivo) throws IOException {
        service.guardarArchivoEnBaseDeDatos(archivo);
        RespuestaDTO respuesta = new RespuestaDTO();
        respuesta.setMensaje("Archivo guardado exitosamente");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/descargarArchivo/{id}")
    public ResponseEntity<byte[]> descargarArchivo(@PathVariable Long id) throws Exception {
        Optional<Archivo> file = service.descargarArchivo(id);

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, file.get().getTipoArchivo())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.get().getNombreArchivo() + "\"")
                .body(file.get().getDatosArchivo());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Archivo>> listarArchivos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<RespuestaDTO> eliminarArchivo(@PathVariable Long id) {
        service.eliminarArchivo(id);
        RespuestaDTO respuesta = new RespuestaDTO();
        respuesta.setMensaje("Archivo eliminado exitosamente");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<?> verInformacionArchivo(@PathVariable Long id) throws Exception {
        Optional<Archivo> file = service.descargarArchivo(id);
        return ResponseEntity.ok(java.util.Map.of(
                "id", file.get().getIdArchivo(),
                "nombre", file.get().getNombreArchivo(),
                "tipo", file.get().getTipoArchivo(),
                "tamaño", file.get().getDatosArchivo().length + " bytes"
        ));
    }
}