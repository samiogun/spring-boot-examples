package org.ersun.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String msg){
        super(msg);
    }

}
