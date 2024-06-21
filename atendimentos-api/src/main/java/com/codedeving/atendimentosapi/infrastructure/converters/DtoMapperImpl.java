package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.dtos.AtendimentoDto;
import com.codedeving.atendimentosapi.infrastructure.dtos.PacienteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        return new Atendimento(
                dto.id(),
                dto.dataAtendimento(),
                dto.nomeProfissional(),
                dto.especialidadeEnum(),
                dto.registroAtendimento(),
                dto.retorno(),
                new Paciente((dto.pacienteId()))
        );
    }

    @Override
    public PacienteDto toPacienteDto(Paciente paciente) {
        List<Atendimento> atendimentos = paciente.getAtendimentos();

//        List<AtendimentoDto> atendimentosDto = paciente.getAtendimentos().stream()
//                .map(this::toAtendimentoDto)
//                .collect(Collectors.toList());

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

//    @Override
//    public AtendimentoDto toAtendimentoDto(Atendimento atendimento) {
//        return new AtendimentoDto(
//                atendimento.getId(),
//                atendimento.getDataAtendimento(),
//                atendimento.getNomeProfissional(),
//                atendimento.getEspecialidade(),
//                atendimento.getRegistroAtendimento(),
//                atendimento.getRetorno(),
//                atendimento.getPaciente().getId()
//        );
//    }

//    @Override
//    public AtendimentoDto toAtendimentoDto(Atendimento atendimento) {
//        System.out.println("DtoMapperImpl entrada =======> " + atendimento);
//        Paciente paciente = atendimento.getPaciente();
//        Integer pacienteId = paciente != null ? paciente.getId() : null;
//
//        return new AtendimentoDto(
//                atendimento.getId(),
//                atendimento.getDataAtendimento(),
//                atendimento.getNomeProfissional(),
//                atendimento.getEspecialidade(),
//                atendimento.getRegistroAtendimento(),
//                atendimento.getRetorno(),
//                pacienteId
//        );
//    }
@Override
public AtendimentoDto toAtendimentoDto(Atendimento atendimento) {
    System.out.println("DtoMapperImpl entrada =======> " + atendimento);

    Paciente paciente = atendimento.getPaciente();
    Integer pacienteId = paciente != null ? paciente.getId() : null;

    AtendimentoDto atendimentoDto = new AtendimentoDto(
            atendimento.getId(),
            atendimento.getDataAtendimento(),
            atendimento.getNomeProfissional(),
            atendimento.getEspecialidade(),
            atendimento.getRegistroAtendimento(),
            atendimento.getRetorno(),
            pacienteId
    );

    System.out.println("DtoMapperImpl saída =======> " + atendimentoDto);

    return atendimentoDto;
}


}