package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Login;

import java.util.Properties;

public class Emailsender {

	 public static void sendEmail(Login login) {
		String message = "Hello, Welcome to party managaement app!!";
		String subject = "Confirmation of mail";
		String to = login.getEmail();
		String from = "********************";
		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println(properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("*****************", "*********");
			}
		});

		session.setDebug(true);

		MimeMessage demoMessage = new MimeMessage(session);

		try {
			demoMessage.setFrom(from);
			demoMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			demoMessage.setSubject(subject);
			demoMessage.setText(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Transport.send(demoMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Email Successfully sent");
	}
}