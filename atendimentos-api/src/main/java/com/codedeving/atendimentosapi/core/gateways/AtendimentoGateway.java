package com.codedeving.atendimentosapi.core.gateways;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface AtendimentoGateway {

   Atendimento createAtendimento(Integer pacienteId, Atendimento atendimento);
    //Atendimento createAtendimento(Atendimento atendimento);

    void deleteAtendimento(Integer id);

    Optional<Atendimento> findById(Integer id);

    Page<Atendimento> obtainAllAtendimentos(Integer pagina, Integer tamanhoPagina);

    Atendimento updateAtendimento(Integer id, Atendimento atendimento);


}
