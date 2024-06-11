package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import org.springframework.data.domain.Page;

public class GetAllPacienteUseCaseImpl implements GetAllPacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public GetAllPacienteUseCaseImpl(PacienteGateway pacienteGateway) {

        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public Page<Paciente> execute(Integer pagina, Integer tamanhoPagina) {
        return pacienteGateway.obtainAllPacientes(pagina, tamanhoPagina);
    }

}

