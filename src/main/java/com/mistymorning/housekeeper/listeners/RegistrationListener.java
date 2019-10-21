package com.mistymorning.housekeeper.listeners;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.mistymorning.housekeeper.classes.User;
import com.mistymorning.housekeeper.events.OnRegistrationCompleteEvent;
import com.mistymorning.housekeeper.services.api.UserService;

@Component()
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private UserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
    	LOG.debug("Registration Listener in listeners package detected OnRegistrationCompleteEvent");
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);
        LOG.debug("Creating verification token for new user {}",event.getUser().getEmail());
        final SimpleMailMessage email = constructEmailMessage(event, user, token);
        mailSender.send(email);
    }

    //

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        LOG.debug("Email message text: {}",message + " \r\n" + confirmationUrl);
        LOG.debug("Email message sent from: {}",env.getProperty("spring.mail.username"));
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("spring.mail.username"));
        return email;
    }

}