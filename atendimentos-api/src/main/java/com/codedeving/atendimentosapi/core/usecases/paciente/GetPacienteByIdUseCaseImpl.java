package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

import java.util.Optional;

public class GetPacienteByIdUseCaseImpl implements GetPacienteByIdUseCase {

    private final PacienteGateway pacienteGateway;

    public GetPacienteByIdUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

//    @Override
//    public Paciente execute(Integer id) {
//        return pacienteGateway.findById(id)
//                .orElseThrow(() -> new PacienteNotFoundException());
//    }

    @Override
    public Paciente execute(Integer id) {
        Optional<Paciente> optionalPaciente = pacienteGateway.findById(id);

        // Imprime o resultado da busca
        System.out.println("GetPacienteByIdUseCaseImpl Retorno pacienteGateway.findById: -----> " + optionalPaciente + " ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if (optionalPaciente.isPresent()) {
            return optionalPaciente.get();
        } else {
            throw new PacienteNotFoundException();
        }
    }

}
