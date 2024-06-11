package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;

import java.util.Optional;

public interface GetAtendimentoByIdUseCase {
    Atendimento execute(Integer id);
}
