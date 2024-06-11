package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.exceptions.PacienteExistingException;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class CreatePacienteUseCaseImpl implements CreatePacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public CreatePacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }
    @Override
    public Paciente execute(Paciente paciente) {
        pacienteGateway.findByCpf(paciente.getCpf())
                .ifPresent(existingPaciente -> {
                    throw new PacienteExistingException("Já existe um paciente com CPF '" + paciente.getCpf() + "' cadastrado!");
                });
        return pacienteGateway.createPaciente(paciente);
    }

}
