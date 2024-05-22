package com.codedeving.atendimentosapi.core.domain;

public record Paciente(Integer id,
                       String nome,
                       String cpf,
                       String idade,
                       String email,
                       Boolean favorito,
                       byte[] foto) {}
