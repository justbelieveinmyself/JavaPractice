package Sockets;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

public class EMail {
    public static void main(String[] args) throws IOException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        // Enable specific SSL/TLS protocol and cipher suite
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.ciphers", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        try(OutputStream outputStream = new FileOutputStream("emailprops")){
            props.store(outputStream, "zero");
        }
        
        final Properties properties = new Properties();
        properties.load(new FileReader("emailprops"));
        System.out.println(properties.keySet());
        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("blackshadowich11@gmail.com"));
        message.addRecipients(Message.RecipientType.TO, "blackshadowich11@gmail.com");
        message.setSubject("Test java.mail api");
        message.setText("""
                Hello from Intellij Idea project named EMail.java.
                This message sended by Me for me.
                Have a nice day!)
                With love, me.
                """);

        Transport transport = mailSession.getTransport();
        transport.connect("blackshadowich11@gmail.com", "ljayyewsvetxgeqh"); // ljayyewsvetxgeqh - this gmail password
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
}
