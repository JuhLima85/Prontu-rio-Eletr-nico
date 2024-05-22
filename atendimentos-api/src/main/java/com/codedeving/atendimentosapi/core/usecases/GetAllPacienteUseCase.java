package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import org.springframework.data.domain.Page;

public interface GetAllPacienteUseCase {

    //public List<Contato> execute();
    public Page<Paciente> execute(Integer pagina, Integer tamanhoPagina);

}
