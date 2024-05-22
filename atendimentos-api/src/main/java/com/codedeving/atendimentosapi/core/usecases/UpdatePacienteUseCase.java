package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;

public interface UpdatePacienteUseCase {

    public Paciente execute(Integer id, Paciente paciente);
}
