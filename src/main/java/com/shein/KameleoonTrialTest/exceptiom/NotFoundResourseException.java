package com.shein.KameleoonTrialTest.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResourseException extends RuntimeException {
    public NotFoundResourseException(String msg){
        super(msg);
    }
}
