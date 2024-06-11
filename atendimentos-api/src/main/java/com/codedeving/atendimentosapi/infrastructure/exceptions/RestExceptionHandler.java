package com.codedeving.atendimentosapi.infrastructure.exceptions;


import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.exceptions.PacienteExistingException;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.exceptions.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PacienteNotFoundException.class)
    private ResponseEntity<RestErrorMessage> pacienteNotFoundException(PacienteNotFoundException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(PacienteExistingException.class)
    private ResponseEntity<RestErrorMessage> pacienteExistingException(PacienteExistingException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(AtendimentoNotFoundException.class)
    private ResponseEntity<RestErrorMessage> atendimentoNotFoundException(AtendimentoNotFoundException e) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
