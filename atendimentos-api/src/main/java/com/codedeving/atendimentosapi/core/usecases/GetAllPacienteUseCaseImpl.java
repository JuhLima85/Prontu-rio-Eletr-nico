package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import org.springframework.data.domain.Page;

public class GetAllPacienteUseCaseImpl implements GetAllPacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public GetAllPacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    //    @Override
//    public List<Contato> execute() {
//        return contatoGateway.obtainAllContatos();
//    }

    @Override
    public Page<Paciente> execute(Integer pagina, Integer tamanhoPagina) {
        return pacienteGateway.obtainAllPacientes(pagina, tamanhoPagina);
    }

}

