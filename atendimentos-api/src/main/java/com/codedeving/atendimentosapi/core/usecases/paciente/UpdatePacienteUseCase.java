package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;

public interface UpdatePacienteUseCase {

    Paciente execute(Integer id, Paciente paciente);
}
