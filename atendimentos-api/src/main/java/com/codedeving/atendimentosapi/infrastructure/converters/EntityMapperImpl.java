package com.codedeving.atendimentosapi.infrastructure.converters;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapperImpl implements EntityMapper {

    // Converte um PacienteEntity para um Paciente (domínio)
    @Override
    public Paciente toPacienteDomain(PacienteEntity entity) {
        // Mapeia a lista de AtendimentoEntity para Atendimento (domínio)
        List<Atendimento> atendimentos = entity.getAtendimentos().stream()
                .map(this::toAtendimentoDomain) // Chamando o próprio mapper para converter AtendimentoEntity para Atendimento
                .collect(Collectors.toList());

        return new Paciente(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getIdade(),
                entity.getEmail(),
                entity.getFavorito(),
                entity.getFoto(),
                atendimentos
        );
    }

    // Converte um Paciente (domínio) para um PacienteEntity
    @Override
    public PacienteEntity toPacienteEntity(Paciente domain) {
        // Mapeia a lista de Atendimento (domínio) para AtendimentoEntity
        List<AtendimentoEntity> atendimentos = domain.getAtendimentos().stream()
                .map(this::toAtendimentoEntity) // Chamando o próprio mapper para converter Atendimento para AtendimentoEntity
                .collect(Collectors.toList());

        return new PacienteEntity(
                domain.getId(),
                domain.getNome(),
                domain.getCpf(),
                domain.getIdade(),
                domain.getEmail(),
                domain.getFavorito(),
                domain.getFoto(),
                atendimentos
        );
    }

    // Converte um AtendimentoEntity para um Atendimento (domínio)
    @Override
    public Atendimento toAtendimentoDomain(AtendimentoEntity entity) {
        return new Atendimento(
                entity.getId(),
                entity.getDataAtendimento(),
                entity.getNomeProfissional(),
                entity.getEspecialidadeEnum(),
                entity.getRegistroAtendimento(),
                entity.getRetorno(),
                null // ou entity.getPaciente() para associar o paciente de domínio, se necessário
        );
    }

    // Converte um Atendimento (domínio) para um AtendimentoEntity
    @Override
    public AtendimentoEntity toAtendimentoEntity(Atendimento domain) {
        AtendimentoEntity entity = new AtendimentoEntity();
        entity.setId(domain.getId());
        entity.setDataAtendimento(domain.getDataAtendimento());
        entity.setNomeProfissional(domain.getNomeProfissional());
        entity.setEspecialidadeEnum(domain.getEspecialidade());
        entity.setRegistroAtendimento(domain.getRegistroAtendimento());
        entity.setRetorno(domain.getRetorno());
        // associar o paciente entidade se necessário
        return entity;
    }
}
