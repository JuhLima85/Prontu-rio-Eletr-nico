package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.dtos.AtendimentoDto;
import com.codedeving.atendimentosapi.infrastructure.dtos.PacienteDto;

public interface DtoMapper {
    Paciente toPacienteDomain(PacienteDto dto);
    Atendimento toAtendimentoDomain(AtendimentoDto dto);
    PacienteDto toPacienteDto(Paciente paciente);
    AtendimentoDto toAtendimentoDto(Atendimento atendimento);

}
