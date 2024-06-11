package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;

public interface UpdateAtendimentoUseCase {
    Atendimento execute(Integer id, Atendimento atendimento);
    void validateAtendimento(Atendimento atendimento);
}
