package org.ersun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IndividualNotFoundException extends RuntimeException{

    public IndividualNotFoundException(String message){
        super(message);
    }

}
