package com.codedeving.atendimentosapi.infrastructure.dtos;

public record PacienteDto(Integer id,
                          String nome,
                          String cpf,
                          String idade,
                          String email,
                          Boolean favorito,
                          byte[] foto) {
}
