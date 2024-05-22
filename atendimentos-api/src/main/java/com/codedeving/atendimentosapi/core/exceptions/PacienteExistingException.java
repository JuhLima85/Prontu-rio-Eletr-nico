package com.codedeving.atendimentosapi.core.exceptions;

public class PacienteExistingException extends RuntimeException{

    public PacienteExistingException(){
        super("Este paciente já existe!");
    }

    public PacienteExistingException(String mensage){
        super(mensage);
    }
}
