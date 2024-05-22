package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;

public interface GetPacienteByIdUseCase {

    public Paciente execute(Integer id);
}
