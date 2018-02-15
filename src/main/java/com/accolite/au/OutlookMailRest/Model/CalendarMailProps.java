package com.accolite.au.OutlookMailRest.Model;

public class CalendarMailProps {
	public static final String METHOD = "method:REQUEST\n";
	public static final String PRODID = "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\\n\" + \"VERSION:2.0\n";
	public static final String RECIPIENT_ROLE = "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:";
	public static final String METHOD_REQUEST = "method=REQUEST";
	public static final String CHARSET_UTF8 = "charset=UTF-8";
	public static final String COMPONENT_VEVENT = "component=VEVENT";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String CONTENT_CLASS_CALENDARMESSAGE = "urn:content-classes:calendarmessage";
	public static final String CONTENT_CLASS = "Content-Class";
	public static final String CONTENT_ID = "Content-ID";
	public static final String CALENDAR_MESSAGE = "calendar_message";
	public static final String TEXT_OR_CALENDAR = "text/calendar";
	public static final String HOST = "outlook.office365.com";
	public static final String BEGIN_VCALENDAR = "BEGIN:VCALENDAR\n";
	public static final String BEGIN_VEVENT = "BEGIN:VEVENT\n";
	public static final String ORGANIZER = "ORGANIZER:MAILTO:";
	public static final String STARTDATE = "DTSTART:";
	public static final String ENDDATE = "DTEND:";
	public static final String LOCATION = "LOCATION:";
	public static final String TRANSPARENCY_OPAQUE = "TRANSP:OPAQUE\n";
	public static final String SEQUENCE = "SEQUENCE:0\n";
	public static final String UID = "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100000004377FE5C37984842BF9440448399EB02\n";
	public static final String DATETIMESTAMP = "DTSTAMP:";
	public static final String CATEGORIES = "CATEGORIES:";
	public static final String DESCRIPTION = "DESCRIPTION:";
	public static final String SUMMARY = "SUMMARY:";
	public static final String PRIORITY_5 = "PRIORITY:5\n";
	public static final String CLASS_PUBLIC = "CLASS:PUBLIC\n";
	public static final String BEGIN_VALARM = "BEGIN:VALARM\n";
	public static final String TRIGGER = "TRIGGER:PT1440M\n";
	public static final String ACTION_DISPLAY = "ACTION:DISPLAY\\n";
	public static final String DESCRIPTION_REMINDER = "DESCRIPTION:Reminder\n";
	public static final String END_VALARM = "END:VALARM\n";
	public static final String END_VEVENT = "END:VEVENT\n";
	public static final String END_VCALENDAR = "END:VCALENDAR";

	private CalendarMailProps() {

	}
}
