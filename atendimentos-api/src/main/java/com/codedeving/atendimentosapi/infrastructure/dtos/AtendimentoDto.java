package com.codedeving.atendimentosapi.infrastructure.dtos;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.domain.enums.EspecialidadeEnum;
import com.codedeving.atendimentosapi.infrastructure.utils.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public record AtendimentoDto(Integer id,
                            LocalDate dataAtendimento,
                            String nomeProfissional,
                            EspecialidadeEnum especialidadeEnum,
                             //StringBuilder registroAtendimento,

                             String registroAtendimento,
                             //@JsonDeserialize(using = LocalDateDeserializer.class)
                            LocalDate retorno,
                            Integer pacienteId) {}
