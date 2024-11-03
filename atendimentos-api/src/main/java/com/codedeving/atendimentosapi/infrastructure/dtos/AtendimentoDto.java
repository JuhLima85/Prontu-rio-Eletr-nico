package com.codedeving.atendimentosapi.infrastructure.dtos;

import com.codedeving.atendimentosapi.core.domain.enums.EspecialidadeEnum;
import java.time.LocalDate;

public record AtendimentoDto(Integer id,
                            LocalDate dataAtendimento,
                            String nomeProfissional,
                            EspecialidadeEnum especialidadeEnum,
                             //StringBuilder registroAtendimento,

                             String registroAtendimento,
                            LocalDate retorno,
                            Integer pacienteId) {}
