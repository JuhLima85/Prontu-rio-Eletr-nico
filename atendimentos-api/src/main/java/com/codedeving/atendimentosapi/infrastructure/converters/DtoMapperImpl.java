package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.dtos.AtendimentoDto;
import com.codedeving.atendimentosapi.infrastructure.dtos.PacienteDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapperImpl implements DtoMapper {

    @Override
    public Paciente toPacienteDomain(PacienteDto dto) {
        List<Atendimento> atendimentos = dto.atendimentos() != null ?
                dto.atendimentos() :
                null;

        return new Paciente(
                dto.id(),
                dto.nome(),
                dto.cpf(),
                dto.idade(),
                dto.email(),
                dto.favorito(),
                dto.foto(),
                atendimentos
        );
    }

    @Override
    public Atendimento toAtendimentoDomain(AtendimentoDto dto) {
        Paciente paciente = dto.pacienteId() != null ? new Paciente(dto.pacienteId()) : null;

        return new Atendimento(
                dto.id(),
                dto.dataAtendimento(),
                dto.nomeProfissional(),
                dto.especialidadeEnum(),
                dto.registroAtendimento(),
                dto.retorno(),
                paciente
        );
    }

    @Override
    public PacienteDto toPacienteDto(Paciente paciente) {
        List<Atendimento> atendimentos = paciente.getAtendimentos();

        return new PacienteDto(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getIdade(),
                paciente.getEmail(),
                paciente.getFavorito(),
                paciente.getFoto(),
                atendimentos
        );
    }

    @Override
    public AtendimentoDto toAtendimentoDto(Atendimento atendimento) {
        Paciente paciente = atendimento.getPaciente();
        Integer pacienteId = paciente != null ? paciente.getId() : null;

        return new AtendimentoDto(
                atendimento.getId(),
                atendimento.getDataAtendimento(),
                atendimento.getNomeProfissional(),
                atendimento.getEspecialidade(),
                atendimento.getRegistroAtendimento(),
                atendimento.getRetorno(),
                pacienteId
        );
    }
}