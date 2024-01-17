package com.Illusion0DEV.Controllers;

import com.Illusion0DEV.Application.Service.EmailSendServices;
import com.Illusion0DEV.Repository.DTO.EmailRequest;
import com.Illusion0DEV.Repository.Exception.EmailSendServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSendController {
    private final EmailSendServices emailSendServices;

    @Autowired
    public  EmailSendController(EmailSendServices emailServices){
        this.emailSendServices = emailServices;
    }

    @PostMapping()
    public ResponseEntity<String> SendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSendServices.SendEmail(request.To(), request.Subject(), request.Body());
            return ResponseEntity.ok("Email send successfully");
        }catch(EmailSendServiceException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
