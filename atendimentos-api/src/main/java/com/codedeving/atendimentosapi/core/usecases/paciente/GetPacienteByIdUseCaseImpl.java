package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class GetPacienteByIdUseCaseImpl implements GetPacienteByIdUseCase {

    private final PacienteGateway pacienteGateway;

    public GetPacienteByIdUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public Paciente execute(Integer id) {
        return pacienteGateway.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException());
    }
}
