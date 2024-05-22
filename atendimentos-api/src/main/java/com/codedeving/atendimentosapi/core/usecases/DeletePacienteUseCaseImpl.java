package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class DeletePacienteUseCaseImpl implements DeletePacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public DeletePacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public void execute(Integer id) {
        pacienteGateway.deletePaciente(id);
    }
}
