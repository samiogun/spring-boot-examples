package org.ersun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler { // ResponseEntityExceptionHandler sınıfını extend ederek hali hazırda tüm exceptionlarıda kapsamış oluyoruz. Overrida ederek handle edebiliyoruz.

    @ExceptionHandler(IndividualNotFoundException.class)
    public ResponseEntity<?> individualNotFoundException(IndividualNotFoundException ex){

        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<?> AddressNotFoundException(AddressNotFoundException ex){

        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);

    }

}
