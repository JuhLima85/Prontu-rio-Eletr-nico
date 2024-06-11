package com.codedeving.atendimentosapi.infrastructure.configuration;

import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import com.codedeving.atendimentosapi.core.usecases.atendimento.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtendimentoBeansConfig {

    @Bean
    public CreateAtendimentoUseCase createAtendimentoUseCase(AtendimentoGateway atendimentoGateway, PacienteGateway pacienteGateway){
        return new CreateAtendimentoUseCaseImpl(atendimentoGateway, pacienteGateway);
    }

    @Bean
    public GetAllAtendimentosUseCase getAllAtendimentosUseCase(AtendimentoGateway atendimentoGateway){
        return new GetAllAtendimentosUseCaseImpl(atendimentoGateway);
    }

    @Bean
    public GetAtendimentoByIdUseCase getAtendimentoByIdUseCase(AtendimentoGateway atendimentoGateway){
        return new GetAtendimentoByIdUseCaseImpl(atendimentoGateway);
    }

    @Bean
    public DeleteAtendimentoUseCase deleteAtendimentoUseCase(AtendimentoGateway atendimentoGateway){
        return new DeleteAtendimentoUseCaseImpl(atendimentoGateway);
    }

    @Bean
    public UpdateAtendimentoUseCase updateAtendimentoUseCase(AtendimentoGateway atendimentoGateway){
        return new UpdateAtendimentoUseCaseImpl(atendimentoGateway);
    }
}
