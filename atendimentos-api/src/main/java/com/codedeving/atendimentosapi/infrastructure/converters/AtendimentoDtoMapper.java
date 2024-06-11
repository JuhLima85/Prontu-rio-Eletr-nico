package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.infrastructure.dtos.AtendimentoDto;

import org.springframework.stereotype.Component;

@Component
public class AtendimentoDtoMapper {

    public AtendimentoDto toDTO(Atendimento atendimento){
        return new AtendimentoDto(
                atendimento.getId(),
                atendimento.getDataAtendimento(),
                atendimento.getNomeProfissional(),
                atendimento.getEspecialidade(),
                atendimento.getRegistroAtendimento(),
                atendimento.getRetorno(),
                atendimento.getPaciente());
    }

    public Atendimento toDomain(AtendimentoDto atendimentoDto){
        return new Atendimento(
                atendimentoDto.id(),
                atendimentoDto.dataAtendimento(),
                atendimentoDto.nomeProfissional(),
                atendimentoDto.especialidadeEnum(),
                atendimentoDto.registroAtendimento(),
                atendimentoDto.retorno(),
                atendimentoDto.paciente());
    }
}
