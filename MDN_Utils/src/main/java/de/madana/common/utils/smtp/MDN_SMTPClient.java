package de.madana.common.utils.smtp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MDN_SMTPClient
{

	private String strUsername;
	private String strPassword;
	private String strFrom;
	Properties oEmailProperties;

	/**
	 * 
	 * @param username
	 * @param password
	 * @param host
	 * @param from
	 * @param port
	 * @param authenticate
	 * @param startTLS
	 */
	public MDN_SMTPClient(String username, String password, String host, String from, String port, boolean authenticate, boolean startTLS)
	{
		strUsername = username;
		strPassword= password;
		strFrom = from;

		oEmailProperties = new Properties();
		oEmailProperties.put("mail.smtp.auth", String.valueOf(authenticate));
		oEmailProperties.put("mail.smtp.starttls.enable", String.valueOf(startTLS));
		oEmailProperties.put("mail.smtp.host", host);
		oEmailProperties.put("mail.smtp.port",port);
	}
	/**
	 * 
	 * @param strSubject
	 * @param strReceiver
	 * @param strMailContent
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendMail(String strSubject, String strReceiver, String strMailContent) throws AddressException, MessagingException
	{
		Session session = Session.getInstance(oEmailProperties,
				new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(strUsername, strPassword);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(strFrom));
		message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(strReceiver));
		message.setSubject(strSubject);
		message.setContent(strMailContent,"text/html");

		// Send message
		Transport.send(message);
	}
	public static void main(String[] args) 
	{
		MDN_SMTPClient oClient = new MDN_SMTPClient("noreply@community.madana.io", "!ndkölashd7üUJIKlködssöJ" 
				, "smtp.1und1.de", "noreply@community.madana.io", "587", true, true);
		
		try {
			oClient.sendMail("TEST", "wenisch@madana.io", "sdsadasdsda");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}