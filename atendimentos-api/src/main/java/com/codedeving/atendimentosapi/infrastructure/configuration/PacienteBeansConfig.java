package com.codedeving.atendimentosapi.infrastructure.configuration;

import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import com.codedeving.atendimentosapi.core.usecases.paciente.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteBeansConfig {

    @Bean
    public CreatePacienteUseCase createContatoUseCase(PacienteGateway pacienteGateway){
        return new CreatePacienteUseCaseImpl(pacienteGateway);
    }

    @Bean
    public DeletePacienteUseCase deleteContatoUseCase(PacienteGateway pacienteGateway){
        return new DeletePacienteUseCaseImpl(pacienteGateway);
    }

    @Bean
    public GetAllPacienteUseCase getAllContatosUseCase(PacienteGateway pacienteGateway){
        return new GetAllPacienteUseCaseImpl(pacienteGateway);
    }

    @Bean
    public GetPacienteByIdUseCase getContatoByIdUseCase(PacienteGateway pacienteGateway){
        return new GetPacienteByIdUseCaseImpl(pacienteGateway);
    }

    @Bean
    public FavoritePacienteUseCase favoriteContatoUseCase(PacienteGateway pacienteGateway){
        return new FavoritePacienteUseCaseImpl(pacienteGateway);
    }

    @Bean
    public UpdatePacienteUseCase updateContatoUseCase(PacienteGateway pacienteGateway){
        return  new UpdatePacienteUseCaseImpl(pacienteGateway);
    }

    @Bean
    public AddPhotoUseCase addPhotoUseCase(PacienteGateway pacienteGateway){
        return new AddPhotoUseCaseImpl(pacienteGateway);
    }
}
