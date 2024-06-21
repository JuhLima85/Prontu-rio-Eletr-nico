package com.codedeving.atendimentosapi.infrastructure.dtos;
import com.codedeving.atendimentosapi.core.domain.Atendimento;


import java.util.List;

public record PacienteDto(Integer id,
                          String nome,
                          String cpf,
                          String idade,
                          String email,
                          Boolean favorito,
                          byte[] foto,
                          List<Atendimento> atendimentos) {}


