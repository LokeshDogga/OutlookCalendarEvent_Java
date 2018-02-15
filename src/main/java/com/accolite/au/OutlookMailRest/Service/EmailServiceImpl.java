package com.accolite.au.OutlookMailRest.Service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.accolite.au.OutlookMailRest.Model.CalendarMailProps;
import com.accolite.au.OutlookMailRest.Model.Email;
import com.accolite.au.OutlookMailRest.Model.EmailProps;

public class EmailServiceImpl implements EmailService {

	@Override
	public void send(final Email email) {

		try {

			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put(CalendarMailProps.MAIL_SMTP_HOST, CalendarMailProps.HOST);
			props.put(CalendarMailProps.MAIL_SMTP_AUTH, "true");
			props.put(CalendarMailProps.MAIL_SMTP_STARTTLS_ENABLE, "true");
			props.put(CalendarMailProps.MAIL_SMTP_PORT, "587");

			// authenticate
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email.getUser().getUsername(), email.getUser().getPassword());
				}
			});

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.addHeaderLine(CalendarMailProps.METHOD_REQUEST);
			message.addHeaderLine(CalendarMailProps.CHARSET_UTF8);
			message.addHeaderLine(CalendarMailProps.COMPONENT_VEVENT);
			message.setFrom(new InternetAddress(email.getSender()));

			String[] recipientList = email.getRecipient().split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			StringBuilder recipients = new StringBuilder();
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
				recipients.append(CalendarMailProps.RECIPIENT_ROLE).append(recipient).append("\n");
			}

			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject(email.getSubject());

			StringBuilder buffe = setEmailProps(email.getEmailProps(), email.getSender(), recipients.toString());

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setHeader(CalendarMailProps.CONTENT_CLASS, CalendarMailProps.CONTENT_CLASS_CALENDARMESSAGE);
			messageBodyPart.setHeader(CalendarMailProps.CONTENT_ID, CalendarMailProps.CALENDAR_MESSAGE);
			messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(buffe.toString(), CalendarMailProps.TEXT_OR_CALENDAR)));
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException me) {
			me.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public StringBuilder setEmailProps(EmailProps emailProps, String sender, String recipients) {
		StringBuilder strbuilder = new StringBuilder();

		strbuilder.append(CalendarMailProps.BEGIN_VCALENDAR).append(CalendarMailProps.PRODID).append(CalendarMailProps.METHOD)
				.append(CalendarMailProps.BEGIN_VEVENT).append(recipients).append("\n")
				.append(CalendarMailProps.ORGANIZER).append(sender).append("\n").append(CalendarMailProps.STARTDATE)
				.append(emailProps.getStartDateTime()).append("\n").append(CalendarMailProps.ENDDATE)
				.append(emailProps.getEndDataTime()).append("\n").append(CalendarMailProps.LOCATION)
				.append(emailProps.getLocation()).append("\n").append(CalendarMailProps.TRANSPARENCY_OPAQUE)
				.append(CalendarMailProps.SEQUENCE).append(CalendarMailProps.UID)
				.append(CalendarMailProps.DATETIMESTAMP).append(emailProps.getDateTimeStamp()).append("\n")
				.append(CalendarMailProps.CATEGORIES).append(emailProps.getCategory()).append("\n")
				.append(CalendarMailProps.DESCRIPTION).append(emailProps.getDescription()).append("\n")
				.append(CalendarMailProps.SUMMARY).append(emailProps.getSummary()).append("\n")
				.append(CalendarMailProps.PRIORITY_5).append(CalendarMailProps.CLASS_PUBLIC)
				.append(CalendarMailProps.BEGIN_VALARM).append(CalendarMailProps.TRIGGER)
				.append(CalendarMailProps.ACTION_DISPLAY).append(CalendarMailProps.DESCRIPTION_REMINDER)
				.append(CalendarMailProps.END_VALARM).append(CalendarMailProps.END_VEVENT)
				.append(CalendarMailProps.END_VCALENDAR);

		return strbuilder;
	}
}
