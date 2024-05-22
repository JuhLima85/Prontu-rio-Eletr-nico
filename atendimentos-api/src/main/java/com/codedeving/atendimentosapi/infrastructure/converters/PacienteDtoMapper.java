package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.dtos.PacienteDto;
import org.springframework.stereotype.Component;

@Component
public class PacienteDtoMapper {

    public PacienteDto toDTO(Paciente paciente){
        return new PacienteDto(paciente.id(), paciente.nome(), paciente.cpf(), paciente.idade(), paciente.email(), paciente.favorito(), paciente.foto());
    }

    public Paciente toDomain(PacienteDto pacienteDto){
        return new Paciente(pacienteDto.id(), pacienteDto.nome(), pacienteDto.cpf(), pacienteDto.idade(), pacienteDto.email(), pacienteDto.favorito(), pacienteDto.foto());
    }

}
