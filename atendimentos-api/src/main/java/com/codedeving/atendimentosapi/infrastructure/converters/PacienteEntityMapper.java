package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteEntityMapper {

    public PacienteEntity toEntity(Paciente paciente){
        return new PacienteEntity(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getIdade(),
                paciente.getEmail(),
                paciente.getFavorito(),
                paciente.getFoto()
        );
    }

    public Paciente toPaciente(PacienteEntity entity){
        return new Paciente(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getIdade(),
                entity.getEmail(),
                entity.getFavorito(),
                entity.getFoto()
        );
    }
}
