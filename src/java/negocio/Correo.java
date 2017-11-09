/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.websocket.Session;

/**
 *
 * @author cruzd
 */
public class Correo {

    public void SendMail(String mensaje, String destino, String asunto) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("proyecto.apoyo.udistrital@gmail.com", "apoyo123456");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("proyecto.apoyo.udistrital@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
