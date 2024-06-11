package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import org.springframework.data.domain.Page;

public interface GetAllAtendimentosUseCase {
    Page<Atendimento> execute(Integer pagina, Integer tamanhoPagina);
}
