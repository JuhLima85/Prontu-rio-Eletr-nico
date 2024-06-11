package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class CreateAtendimentoUseCaseImpl implements CreateAtendimentoUseCase{

    private final AtendimentoGateway atendimentoGateway;
    private final PacienteGateway pacienteGateway;

    public CreateAtendimentoUseCaseImpl(AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway) {
        this.atendimentoGateway = atendimentoGateway;
        this.pacienteGateway = pacienteGateway;
    }
    @Override
    public Atendimento execute(Integer pacienteId, Atendimento atendimento) {
        Paciente pacienteExistente = pacienteGateway.findById(pacienteId)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente com ID " + pacienteId + " não encontrado."));
        atendimento.setPaciente(pacienteExistente);
        return atendimentoGateway.createAtendimento(pacienteId, atendimento);
    }

}
