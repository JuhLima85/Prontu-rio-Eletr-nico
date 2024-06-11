package com.codedeving.atendimentosapi.core.usecases.paciente;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import org.springframework.data.domain.Page;

public interface GetAllPacienteUseCase {

    Page<Paciente> execute(Integer pagina, Integer tamanhoPagina);

}
