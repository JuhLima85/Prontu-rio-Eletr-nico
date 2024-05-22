package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class GetPacienteByIdUseCaseImpl implements GetPacienteByIdUseCase {

    private final PacienteGateway pacienteGateway;

    public GetPacienteByIdUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public Paciente execute(Integer id) {
        return pacienteGateway.obterPacientePorId(id);
    }
}
