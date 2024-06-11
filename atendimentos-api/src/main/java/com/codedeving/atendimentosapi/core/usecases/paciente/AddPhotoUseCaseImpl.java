package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import jakarta.servlet.http.Part;

public class AddPhotoUseCaseImpl implements AddPhotoUseCase{

    private final PacienteGateway pacienteGateway;

    public AddPhotoUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public byte[] execute(Integer id, Part arquivo) {
        return pacienteGateway.addPhoto(id, arquivo);
    }
}
