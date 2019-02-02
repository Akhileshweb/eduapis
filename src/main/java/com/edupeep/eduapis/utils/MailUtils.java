package com.edupeep.eduapis.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


/**
 * 
 * @author Mukuljaiswal
 *
 */
@Service
public class MailUtils {
	
	public static String firstName;
	public static String lastName;
	public static String toEmailId;
	public static String fromEmailId;
	public static String subject;
	public static String mailText;
	public static boolean haveAttachment;
	public static String fileAttachemnt;
	
	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	static private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailUtils(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param mailData
	 * @throws MailException
	 * @throws MessagingException
	 */
	public static void sendEmail() throws MailException, MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setText("utf-8", "html");
		helper.setTo(toEmailId);
		helper.setSubject(subject);
		helper.setText(mailText, true);
		
		if(haveAttachment){
		FileSystemResource file = new FileSystemResource(fileAttachemnt);
		helper.addAttachment(file.getFilename(), file);
		}

		javaMailSender.send(message);
	}

}
