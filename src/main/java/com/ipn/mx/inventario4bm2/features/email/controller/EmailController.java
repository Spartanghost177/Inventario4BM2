package com.ipn.mx.inventario4bm2.features.email.controller;

import com.ipn.mx.inventario4bm2.features.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviar(@RequestBody EmailRequest request) {
        emailService.enviarCorreo(
                request.getDestinatario(),
                request.getAsunto(),
                request.getMensaje()
        );
        return "Correo enviado correctamente";
    }

    // Clase interna para recibir el JSON
    public static class EmailRequest {
        private String destinatario;
        private String asunto;
        private String mensaje;

        public String getDestinatario() { return destinatario; }
        public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
        public String getAsunto() { return asunto; }
        public void setAsunto(String asunto) { this.asunto = asunto; }
        public String getMensaje() { return mensaje; }
        public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    }
}