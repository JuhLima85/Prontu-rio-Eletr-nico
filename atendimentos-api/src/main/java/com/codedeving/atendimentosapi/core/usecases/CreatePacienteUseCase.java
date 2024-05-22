package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;

public interface CreatePacienteUseCase {
    public Paciente execute(Paciente paciente);
}
