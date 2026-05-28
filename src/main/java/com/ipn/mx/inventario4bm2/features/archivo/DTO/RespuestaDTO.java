package com.ipn.mx.inventario4bm2.features.archivo.DTO;

public class RespuestaDTO {
    private String mensaje;

    public RespuestaDTO() {}

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}