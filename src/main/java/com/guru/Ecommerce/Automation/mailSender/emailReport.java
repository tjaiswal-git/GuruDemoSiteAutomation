package com.guru.Ecommerce.Automation.mailSender;


import java.util.Date;
import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class emailReport extends com.guru.Ecommerce.Automation.testbase.TestBase {

public static boolean  mailSenderWithAttachement(String to,final String from, final String password) {

    //final String username = "give your email id";
    //final String password = "enter your password";
    boolean type;
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject("Orders List in CSV formatted file");
        message.setText("Orders List in CSV formatted file");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        String filePath=downloadPath+"\\customers.csv";
       // String file = "C:\\Users\\tjaiswal\\workspace\\ZenAuto\\test-output\\emailable-report.html";
        String fileName = "OrdersSheet.csv";
        DataSource source = new FileDataSource(filePath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");
        logger.info("mail has been sent successfully... ");

    } catch (MessagingException e) {
        e.printStackTrace();
      //  return type=false;
    }
    return type=true;
    }

public static void sendMailWithoutAttachment(String to,final String from, final String password,String msgSubject,String msgText)
{
	
	    //final String username = "give your email id";
	    //final String password = "enter your password";

	    Properties props = new Properties();
	   
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    //props.setProperty("mail.debug", "true");
	 
	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(from, password);
	                }
	            });

	    try {
	    //	"Dear Mail Crawler,"
			//		+ "\n\n No spam to my email, please!

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	        message.setSentDate(new Date());
	        message.setSubject(msgSubject);
	        message.setText(msgText);
	        sleepTime(2);
	        
	      	        

	        System.out.println("Sending");

	         Transport.send(message);   
	        System.out.println("Done");
	        logger.info("mail has been sent successfully... ");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }
}
