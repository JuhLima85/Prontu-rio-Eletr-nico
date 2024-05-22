package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteEntityMapper {

    public PacienteEntity toEntity(Paciente paciente){
        return new PacienteEntity(paciente.id(), paciente.nome(), paciente.cpf(), paciente.idade(), paciente.email(), paciente.favorito(), paciente.foto());
    }

    public Paciente toPaciente(PacienteEntity entity){
        return new Paciente(entity.getId(), entity.getNome(), entity.getCpf(), entity.getIdade(), entity.getEmail(), entity.getFavorito(), entity.getFoto());
    }
}
