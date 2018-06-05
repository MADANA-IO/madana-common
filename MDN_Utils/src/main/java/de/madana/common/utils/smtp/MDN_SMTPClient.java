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
		oEmailProperties.put("mail.smtp.ssl.trust", "*");
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
		message.setContent(strMailContent + getFooter(),"text/html");

		// Send message
		Transport.send(message);
	}
	private String getFooter() 
	{	
		return "<br>\r\n" + 
				"<br>\r\n" + 
				"Follow us on <a href=\"https://www.facebook.com/madana.io/\">Facebook</a> and <a href=\"https://twitter.com/MADANA_HQ\">Twitter</a>.<br>\r\n" + 
				"Read our <a href=\"https://blog.madana.io/\">Medium Blog</a>.\r\n" + 
				"<br><br>\r\n" + 
				"This message may contain confidential and/or privileged information. If you have received this e-mail in error please notify the sender immediately and delete the material from any computer. <br>\r\n" + 
				"Our company accepts no liability for the content of this email, or for the consequences of any actions taken on the basis of the information provided, unless that information is subsequently confirmed in writing. For discussion purposes only and cannot be used to create a binding contract.";
	}
	public static void main(String[] args) 
	{
		MDN_SMTPClient oClient = new MDN_SMTPClient("noreply@community.madana.io", "!ndkölashd7üUJIKlködssöJ" 
				, "smtp.1und1.de", "noreply@community.madana.io", "587", true, true);
		
		try {
			String strMailText ="<div style =\"bgcolor=#f3f3f6;\">			<div>\r\n" + 
					"                <img src=\"http://www.madana.io/images/logo.png\"\r\n" + 
					"					alt=\"MADANA Logo\"\r\n" + 
					"					width=\"100\" height=\"100\" style=\"text-align:center; \r\n" + 
					"display:block;\"></div><h1>Password reset requested</h1><br> <br> To change the password for your MADANA account, please click on the following link.<br><br>LINK <br><br>"
					+ "This link will become invalid 6 hours after submission. The link will take you to the MADANA account management website, where you can enter a new password.<br>"
					+ "This e-mail was sent automatically. Please do not reply to this mail.</div>";
			oClient.sendMail("TEST", "wenisch@madana.io", strMailText);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}