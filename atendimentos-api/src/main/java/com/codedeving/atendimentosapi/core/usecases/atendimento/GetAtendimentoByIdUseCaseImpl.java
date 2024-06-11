package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;

public class GetAtendimentoByIdUseCaseImpl implements GetAtendimentoByIdUseCase {
    private final AtendimentoGateway atendimentoGateway;

    public GetAtendimentoByIdUseCaseImpl(AtendimentoGateway atendimentoGateway) {
        this.atendimentoGateway = atendimentoGateway;
    }

    @Override
    public Atendimento execute(Integer id) {
        return atendimentoGateway.findById(id)
                .orElseThrow(() -> new AtendimentoNotFoundException());
    }

}
