package com.Illusion0DEV.Application.Service;

import com.Illusion0DEV.Application.Interface.EmailSendGetway;
import com.Illusion0DEV.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServices implements EmailRepository {

    private final EmailSendGetway emailSendGetway;

    @Autowired
    public  EmailSendServices(EmailSendGetway emailgetway){

        this.emailSendGetway = emailgetway;

    }

    @Override
    public void SendEmail(String To, String Subject, String Body) {
        this.emailSendGetway.sendEmail(To, Subject, Body);

    }
}
