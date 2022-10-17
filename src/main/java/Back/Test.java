package Back;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test extends User{

	public static void main(String[] args) {
		String recipient = "Parinitha.Pembarthi@planonsoftware.com";
		//Parinitha.Pembarthi@planonsoftware.com
	    String sender = "parinitha.p89@gmail.com";
	    String host = "smtp.planonsoftware.com";		      
	    Properties properties = System.getProperties();
	    properties.put("mail.smtp.host", host);
        //properties.put("mail.smtp.port", "465");
        //properties.put("mail.smtp.auth", "true");
        //properties.put("mail.smtp.starttls.enable", "true");
        //properties.put("mail.smtp.user", "parinitha.p89@gmail.com");
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//
//                return new PasswordAuthentication("parinitha.p89@gmail.com","wvzgnmwoxllwcrvd");
//
//            }
//
//        });
        Session session = Session.getDefaultInstance(properties);
	      try
	      {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(sender));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	         message.setSubject("Reset Password");
	         message.setText("Your password is:8989");
//	         Transport t = session.getTransport("smtp");
//	         t.connect(host,"parinitha.p89@gmail.com","wvzgnmwoxllwcrvd");
//	         t.sendMessage(message, message.getAllRecipients());
//	         t.close();
	         Transport.send(message);
	         System.out.println("Mail successfully sent");
	      }
	      catch (MessagingException mex) 
	      {
	         mex.printStackTrace();
	      }

	}

}
