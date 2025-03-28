package Persistence;

import com.google.protobuf.Message;
import com.mysql.cj.xdevapi.Session;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class EmailSender {
    private static final String SMTP_HOST = "sandbox.smtp.mailtrap.io";
    private static final int SMTP_PORT = 2525;
    private static final String SMTP_USER = "e60e271670aa6f";
    private static final String SMTP_PASS = "****28ce";

    public static void enviarEmail(String destinatario, String asunto, String mensaje) {
        // Configurar propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");

        // Crear sesión autenticada
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
            }
        });

        try {
            // Crear el mensaje
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress("no-reply@tuapp.com"));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            email.setSubject(asunto);
            email.setText(mensaje);

            // Enviar el correo
            Transport.send(email);
            System.out.println("Correo enviado a " + destinatario);

        } catch (MessagingException e) {
            System.out.println("Error al enviar email: " + e.getMessage());
        }
    }
}
