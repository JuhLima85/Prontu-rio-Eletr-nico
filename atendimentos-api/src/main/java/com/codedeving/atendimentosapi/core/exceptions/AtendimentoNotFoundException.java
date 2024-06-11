package com.codedeving.atendimentosapi.core.exceptions;

public class AtendimentoNotFoundException extends RuntimeException{

    public AtendimentoNotFoundException(){ super("Atendimento não encontrado!");}

    public AtendimentoNotFoundException(String message){ super(message);}
}
