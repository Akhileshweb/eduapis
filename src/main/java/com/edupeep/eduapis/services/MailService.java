package com.edupeep.eduapis.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.edupeep.eduapis.utils.MailData;


/**
 * 
 * @author Mukuljaiswal
 *
 */
@Service
public class MailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param mailData
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmail(MailData mailData) throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setText("utf-8", "html");
		helper.setTo(mailData.getEmailAddress());
		helper.setSubject(mailData.getSubject());
		helper.setText(mailData.getMailText(), true);
		
		if(mailData.isHaveAttachment()){
		FileSystemResource file = new FileSystemResource(mailData.getFileAttachemnt());
		helper.addAttachment(file.getFilename(), file);
		}

		javaMailSender.send(message);
	}

}
