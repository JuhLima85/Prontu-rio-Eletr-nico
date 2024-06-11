package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class DeletePacienteUseCaseImpl implements DeletePacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public DeletePacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    public void execute(Integer id) {
        Paciente paciente = pacienteGateway.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException());
        pacienteGateway.deletePaciente(id);
    }

}
