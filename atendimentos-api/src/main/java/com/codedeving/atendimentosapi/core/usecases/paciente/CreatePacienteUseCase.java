package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;

public interface CreatePacienteUseCase {
    Paciente execute(Paciente paciente);
}
