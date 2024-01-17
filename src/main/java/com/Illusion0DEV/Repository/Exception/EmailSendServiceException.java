package com.Illusion0DEV.Repository.Exception;

public class EmailSendServiceException extends RuntimeException{
    public EmailSendServiceException(String message){
        super(message);
    }

    public EmailSendServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
