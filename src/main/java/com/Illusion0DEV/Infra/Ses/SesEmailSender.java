package com.Illusion0DEV.Infra.Ses;

import com.Illusion0DEV.Application.Interface.EmailSendGetway;
import com.Illusion0DEV.Repository.Exception.EmailSendServiceException;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSendGetway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;

    }
    @Override
    public void sendEmail(String To, String Subject, String Body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("Illusion0DEV@gmail.com")
                .withDestination(new Destination().withToAddresses(To))
                .withMessage(new Message()
                        .withSubject(new Content())
                        .withBody(new Body().withText(new Content(Body)))
                );
        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonServiceException exception){
            throw new EmailSendServiceException("Failure wile sending email", exception);
        }
    }
}
