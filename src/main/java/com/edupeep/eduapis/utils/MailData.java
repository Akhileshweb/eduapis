package com.edupeep.eduapis.utils;

import org.springframework.stereotype.Component;

/**
 * Date :July 25,2018
 * 
 * @author MukulJaiswal
 * @version 1.0
 *
 */
@Component
public class MailData {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String subject;
	private String mailText;
	private String fileAttachemnt;
	private boolean haveAttachment;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFileAttachemnt() {
		return fileAttachemnt;
	}

	public void setFileAttachemnt(String fileAttachemnt) {
		this.fileAttachemnt = fileAttachemnt;
	}

	public boolean isHaveAttachment() {
		return haveAttachment;
	}

	public void setHaveAttachment(boolean haveAttachment) {
		this.haveAttachment = haveAttachment;
	}

	public String getMailText() {
		return mailText;
	}

	public void setMailText(String mailText) {
		this.mailText = mailText;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	
}
