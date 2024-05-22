package com.codedeving.atendimentosapi.core.usecases;

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
        Paciente pacienteExistente = pacienteGateway.findByEmail(paciente.email());
        if(pacienteExistente != null){
            throw new PacienteExistingException("Já existe um paciente com e-mail '" + paciente.email() + "' cadastrado!");
        }
        return pacienteGateway.createPaciente(paciente);
    }
}
