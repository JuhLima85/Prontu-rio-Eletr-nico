package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;

import java.util.Optional;

public class UpdateAtendimentoUseCaseImpl implements UpdateAtendimentoUseCase {
    private final AtendimentoGateway atendimentoGateway;

    public UpdateAtendimentoUseCaseImpl(AtendimentoGateway atendimentoGateway) {
        this.atendimentoGateway = atendimentoGateway;
    }

    @Override
    public Atendimento execute(Integer id, Atendimento atendimento) {
        validateAtendimento(atendimento);

        Optional<Atendimento> existingAtendimentoOpt = atendimentoGateway.findById(id);
        Atendimento existingAtendimento = existingAtendimentoOpt
                .orElseThrow(() -> new AtendimentoNotFoundException("Atendimento com ID " + id + " não encontrado."));

        existingAtendimento.setNomeProfissional(atendimento.getNomeProfissional());
        existingAtendimento.setEspecialidade(atendimento.getEspecialidade());
        existingAtendimento.setRegistroAtendimento(atendimento.getRegistroAtendimento());
        existingAtendimento.setRetorno(atendimento.getRetorno());

        return atendimentoGateway.updateAtendimento(id, existingAtendimento);
    }

    public void validateAtendimento(Atendimento atendimento) {
        if (atendimento.getNomeProfissional() == null || atendimento.getNomeProfissional().isEmpty()) {
            throw new AtendimentoNotFoundException("O campo 'Nome do Profissional' é obrigatório.");
        }
        if (atendimento.getEspecialidade() == null) {
            throw new AtendimentoNotFoundException("O campo 'Especialidade' é obrigatório.");
        }
        if (atendimento.getRegistroAtendimento() == null || atendimento.getRegistroAtendimento().isEmpty()) {
            throw new AtendimentoNotFoundException("O campo 'Registro de Atendimento' é obrigatório.");
        }

    }
}
