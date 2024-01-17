package com.Illusion0DEV.Infra.Ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {
    @Bean
    public AmazonSimpleEmailService emailService(){
        return AmazonSimpleEmailServiceClientBuilder.standard().build();
    }

}
