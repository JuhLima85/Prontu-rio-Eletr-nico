package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;

public class DeleteAtendimentoUseCaseImpl implements DeleteAtendimentoUseCase {

    private final AtendimentoGateway atendimentoGateway;

    public DeleteAtendimentoUseCaseImpl(AtendimentoGateway atendimentoGateway) {
        this.atendimentoGateway = atendimentoGateway;
    }

    public void execute(Integer id) {
        Atendimento atendimento = atendimentoGateway.findById(id)
                .orElseThrow(() -> new AtendimentoNotFoundException());
        atendimentoGateway.deleteAtendimento(id);
    }

}
