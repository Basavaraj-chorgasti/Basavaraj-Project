package sendemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import constant.Constant;

public class Sendemail 
{
	public static void sendemail(String mail,String messages)
	{  
        //Get properties object    
        Properties properties = new Properties();    
        properties.put(Constant.HOST, Constant.GMAIL);    
        properties.put(Constant.FACTORY_PORT, Constant.PNUM);    
        properties.put(Constant.FACTORY_CLASS,Constant.SOCKET);    
        properties.put(Constant.AUTH, Constant.TRUE);    
        properties.put(Constant.PORT,Constant.PNUM);    
        //get Session   
        Session session = Session.getDefaultInstance(properties,    
        new javax.mail.Authenticator() 
        {    
        		protected PasswordAuthentication getPasswordAuthentication()
        		{    
        			return new PasswordAuthentication(Constant.SENDMAILFRON,Constant.PASSWORD);  
        		}    
        });    
        //compose message    
        try
        {
        	MimeMessage message = new MimeMessage(session);    
        	message.setRecipient(Message.RecipientType.TO,new InternetAddress(mail));    
        	message.setSubject(Constant.SUBJECT);    
        	message.setText(messages);    
        	//send message  
        	Transport.send(message);    
        	System.out.println("EMAIL SEND SUCCESSFULLY...");    
        } 	
        catch(MessagingException e) 
        {
      	  	e.printStackTrace();
        }    
	}
}
