package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class FavoritePacienteUseCaseImpl implements FavoritePacienteUseCase {
    private final PacienteGateway pacienteGateway;

    public FavoritePacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public void execute(Integer id) {
        pacienteGateway.favoritePaciente(id);
    }
}
