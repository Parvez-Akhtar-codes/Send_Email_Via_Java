import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class MyEmail {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocol","smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("javaemail7@gmail.com","Jndtak@342");
            }
        });

        Message message = new MimeMessage(session);


        Address addressTo = new InternetAddress("junaidtak747@gmail.com");
        message.setRecipient(Message.RecipientType.TO,addressTo);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("static/father.jpg.jpg"));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Email from java program" , "text/html");
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);

        message.setContent(multipart);

        Transport.send(message);

    }
}
