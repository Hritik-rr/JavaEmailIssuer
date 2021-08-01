package javaemailapplication;

import java.util.Properties;

public class JavaMailUtil {
    public static void sendMail(String recepient)throws Exception{
        System.out.println("Preparaing to send email");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true"); //Key value pair
        properties.put("mail.smtp.starttls.enable", "true"); //Key value pair
        properties.put("mail.smtp.host", "smtp.gmail.com"); //Key value pair
        properties.put("mail.smtp.port", "5087"); //Key value pair
        
       String myAccountEmail = "yagya.madrit@gmail.com";
       String password = "usostwal";
       
       Session session = Session.getInstance(properties, new Authenticator(){
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(myAccountEmail, password)
          } 
       });
        //mail.smtp.auth : defines whether an authentication is needed for the smtp server
        //mail.smtp.starttls.enable: in gmail, providing a true value for this key
        //mail.smtp.host - smtp.gmail.com: host server
        //mail.smtp.host - 5087: port server
        Message message = prepareMessage(session, myAccountEmail, recepient);
        
        Transport.send(message);
        System.out,,println("Message sent seuccessfully");
        
    }
    
    public static Message prepareMessage(Session session, String myAccountEmail, String Recipient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My First Email from Java");
            message.setText("hey There, \n Look at my E-mail");
            return message;
            
            
        } catch (Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}
