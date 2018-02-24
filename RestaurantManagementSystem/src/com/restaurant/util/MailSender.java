package com.restaurant.util;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.restaurant.model.Employee;

public class MailSender {

	public static void sendMailToStudent(Employee emp) throws Exception {

		String adminMailId = AppConfigPropertyReader.getProperty("ADMIN_MAIL_ID");
		String adminPassword = AppConfigPropertyReader.getProperty("ADMIN_MAIL_PASSWORD");

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername(adminMailId);
		mailSender.setPassword(adminPassword);
		mailSender.setHost("smtp.gmail.com");
		mailSender.setProtocol("smtp");
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(prop);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(adminMailId);
		message.setTo(emp.getAddress());
		message.setSubject(AppConfigPropertyReader.getProperty("MAIL_SUBJECT"));
		message.setText("Hi " + emp.getFullname() + ",\n\n" + AppConfigPropertyReader.getProperty("MAIL_CONTENT")
		+"\n\nRegards,\nAdmin");
		mailSender.send(message);
		System.out.println("Mail sent to " + emp.getAddress() + " successfully");
	}

}
