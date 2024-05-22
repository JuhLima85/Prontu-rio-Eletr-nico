package com.codedeving.atendimentosapi.core.exceptions;

public class PacienteNotFoundException extends RuntimeException{

    public PacienteNotFoundException(){
        super("Paciente não encontrado!");
    }

    public PacienteNotFoundException(String message){
        super(message);
    }
}
