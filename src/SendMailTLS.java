

 
import java.io.IOException;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTLS extends Thread{

	//public static boolean retVal;
	public static String email;
	public static String subject;
	public static String message;
	
	public SendMailTLS(String e, String s, String m) throws IOException
	{
		email = e;
		subject = s;
		message = m;
		this.Run();
	}
	
	
	public void Run() throws IOException
	{
		
		
		//retVal = false;
		final String username = Helper.read_Username();
		final String password = Helper.read_Password();
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message1 = new MimeMessage(session);
			message1.setFrom(new InternetAddress("from-email@gmail.com"));
			message1.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message1.setSubject(subject);
			message1.setText(message);
 
			Transport.send(message1);
 
			System.out.println("Mail sent.");
			//retVal = true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}


}