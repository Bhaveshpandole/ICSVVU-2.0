package com.rentalnetwork.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

public boolean sendEmail(String message,String to,String subjet){
    	
		String from="chouhanakash1303@gmail.com";
		
		boolean f=false;
    	String host="smtp.gmail.com";
    	
    	Properties properties=System.getProperties();	
    	System.out.println(properties);
    	
    	properties.put("mail.smtp.host", host);
    	properties.put("mail.smtp.port", "465");
    	properties.put("mail.smtp.ssl.enable", "true");
    	properties.put("mail.smtp.auth", "true");
    	
    	//step 1: to get the session object...
    	Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			
				return new PasswordAuthentication("chouhanakash1303@gmail.com","yqetynvslgjfdyvv");
			}
    		
		});
    	session.setDebug(true);
    	//step 2: compose the message [text,multimedia]
    	MimeMessage m =new MimeMessage(session);
    	try {
    		//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//adding subject to message
			m.setSubject(subjet);
			//adding message
		//	m.setText(message);
			m.setContent(message, "text/html");
			//send message using transport class
			Transport.send(m);
			System.out.println("sent successfully........");
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return f;
    }
}
