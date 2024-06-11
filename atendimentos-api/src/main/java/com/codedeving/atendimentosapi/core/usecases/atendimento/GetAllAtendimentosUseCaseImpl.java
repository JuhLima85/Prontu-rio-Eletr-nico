package com.codedeving.atendimentosapi.core.usecases.atendimento;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;
import org.springframework.data.domain.Page;

public class GetAllAtendimentosUseCaseImpl implements GetAllAtendimentosUseCase {

    private final AtendimentoGateway atendimentoGateway;

    public GetAllAtendimentosUseCaseImpl(AtendimentoGateway atendimentoGateway) {
        this.atendimentoGateway = atendimentoGateway;
    }

    @Override
    public Page<Atendimento> execute(Integer pagina, Integer tamanhoPagina) {
        return atendimentoGateway.obtainAllAtendimentos(pagina, tamanhoPagina);
    }
}
