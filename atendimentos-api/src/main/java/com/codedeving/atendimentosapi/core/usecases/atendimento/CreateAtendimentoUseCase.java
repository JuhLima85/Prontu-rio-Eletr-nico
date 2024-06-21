package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;

public interface CreateAtendimentoUseCase {
    Atendimento execute(Integer pacienteId, Atendimento atendimento);
    //Atendimento execute(Atendimento atendimento);
}
