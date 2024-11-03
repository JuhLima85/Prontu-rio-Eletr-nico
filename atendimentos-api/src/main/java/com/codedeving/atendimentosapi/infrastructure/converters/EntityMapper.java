package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;

public interface EntityMapper {
    Paciente toPacienteDomain(PacienteEntity entity);
    PacienteEntity toPacienteEntity(Paciente domain);
    PacienteEntity toPacienteEntitySemAtendimento(Paciente domain);
    Atendimento toAtendimentoDomain(AtendimentoEntity entity);
    AtendimentoEntity toAtendimentoEntity(Atendimento domain);
}
