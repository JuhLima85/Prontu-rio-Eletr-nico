package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoEntityMapper {

    private final PacienteEntityMapper pacienteEntityMapper;

    public AtendimentoEntityMapper(PacienteEntityMapper pacienteEntityMapper) {
        this.pacienteEntityMapper = pacienteEntityMapper;
    }

    public AtendimentoEntity toEntity(Atendimento atendimento){
    return new AtendimentoEntity(
            atendimento.getId(),
            atendimento.getDataAtendimento(),
            atendimento.getNomeProfissional(),
            atendimento.getEspecialidade(),
            atendimento.getRegistroAtendimento(),
            atendimento.getRetorno(),
            pacienteEntityMapper.toEntity(atendimento.getPaciente())
    );
}

    public Atendimento toAtendimento(AtendimentoEntity entity){
        return new Atendimento(
                entity.getId(),
                entity.getDataAtendimento(),
                entity.getNomeProfissional(),
                entity.getEspecialidadeEnum(),
                entity.getRegistroAtendimento(),
                entity.getRetorno(),
                pacienteEntityMapper.toPaciente(entity.getPaciente())
        );
    }


}