package com.accolite.au.OutlookMailRest.Model;

public class EmailProps {

	
	String startDateTime;
	String endDataTime;
	String dateTimeStamp;
	String location;
	String category;
	String description;
	String summary;

	public EmailProps() {
		super();
	}

	public EmailProps(String startDateTime, String endDataTime, String dateTimeStamp, String location, String category,
			String description, String summary) {
		super();
		this.startDateTime = startDateTime;
		this.endDataTime = endDataTime;
		this.dateTimeStamp = dateTimeStamp;
		this.location = location;
		this.category = category;
		this.description = description;
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public EmailProps setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public EmailProps setCategory(String category) {
		this.category = category;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public EmailProps setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public EmailProps setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public EmailProps setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}

	public String getEndDataTime() {
		return endDataTime;
	}

	public EmailProps setEndDataTime(String endDataTime) {
		this.endDataTime = endDataTime;
		return this;
	}

	public String getDateTimeStamp() {
		return dateTimeStamp;
	}

	public EmailProps setDateTimeStamp(String dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
		return this;
	}

}
