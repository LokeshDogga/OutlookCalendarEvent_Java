package com.accolite.au.OutlookMailRest.Model;

public class Email {

	String sender;
	String recipient;
	String subject;
	User user;
	EmailProps emailProps;

	public Email() {
		super();
	}

	public Email(String sender, String recipient, String subject, User user, EmailProps emailProps) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.user = user;
		this.emailProps = emailProps;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EmailProps getEmailProps() {
		return emailProps;
	}

	public void setEmailProps(EmailProps emailProps) {
		this.emailProps = emailProps;
	}
}
