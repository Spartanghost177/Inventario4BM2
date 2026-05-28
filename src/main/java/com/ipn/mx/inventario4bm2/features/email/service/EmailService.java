package com.ipn.mx.inventario4bm2.features.email.service;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${mailgun.api.key}")
    private String apiKey;

    @Value("${mailgun.domain}")
    private String domain;

    @Value("${mailgun.from}")
    private String fromEmail;

    // ✅ Método que tu controlador está llamando
    public void enviarCorreo(String toEmail, String subject, String text) {
        try {
            System.out.println(" Intentando enviar correo a: " + toEmail);
            System.out.println(" Desde: " + fromEmail);
            System.out.println(" Dominio: " + domain);

            // Crear cliente de Mailgun
            MailgunMessagesApi mailgun = MailgunClient
                    .config("https://api.mailgun.net/", apiKey)
                    .createApi(MailgunMessagesApi.class);

            // Construir el mensaje
            Message message = Message.builder()
                    .from(fromEmail)
                    .to(toEmail)
                    .subject(subject)
                    .text(text)
                    .build();

            // Enviar el mensaje
            MessageResponse response = mailgun.sendMessage(domain, message);
            System.out.println("✅ Correo enviado: " + response.getId());

        } catch (Exception e) {
            System.err.println("❌ Error al enviar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}