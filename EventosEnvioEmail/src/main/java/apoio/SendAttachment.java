
package apoio;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class SendAttachment{  
    public void sendMail(String email, String dest, String fileName) {
        String to = email;//change accordingly  
        final String user="eventmailsender@gmail.com";//change accordingly  
        final String password="univates2020B";//change accordingly  
   
        //1) get the session object     
        Properties properties = System.getProperties();  
        //properties.setProperty("mail.smtp.host", "mail.javatpoint.com");  
        //properties.put("mail.smtp.auth", "true");  
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {  
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {  
                    return new PasswordAuthentication(user,password);  
                }});

        try {
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(user));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject("Certificado");
            //3) create MimeBodyPart object and set your message text     
            BodyPart messageBodyPart1 = new MimeBodyPart();  
            messageBodyPart1.setText("Envio de certificado");  
      
            //4) create new MimeBodyPart object and set DataHandler object to this object      
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
            DataSource source = new FileDataSource(dest);  
            messageBodyPart2.setDataHandler(new DataHandler(source));  
            messageBodyPart2.setFileName(fileName);  
     
            //5) create Multipart object and add MimeBodyPart objects to this object      
            Multipart multipart = new MimeMultipart();  
            multipart.addBodyPart(messageBodyPart1);  
            multipart.addBodyPart(messageBodyPart2);  
  
            //6) set the multiplart object to the message object  
            message.setContent(multipart );
            //7) send message  
            Transport.send(message);  
   
            System.out.println("message sent....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }  
}   




          