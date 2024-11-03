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

    @Override
    public Paciente toPacienteDomain(PacienteEntity entity) {
        // Mapeia a lista de AtendimentoEntity para Atendimento (domínio)
        List<Atendimento> atendimentos = entity.getAtendimentos().stream()
                .map(this::partialToAtendimentoDomain) // Chamando método parcial para evitar recursão
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

    @Override
    public PacienteEntity toPacienteEntity(Paciente domain) {
        // Mapeia a lista de Atendimento (domínio) para AtendimentoEntity
        List<AtendimentoEntity> atendimentos = domain.getAtendimentos().stream()
                .map(this::partialToAtendimentoEntity) // Chamando método parcial para evitar recursão
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

    @Override
    public PacienteEntity toPacienteEntitySemAtendimento(Paciente domain) {
        return new PacienteEntity(
                domain.getId(),
                domain.getNome(),
                domain.getCpf(),
                domain.getIdade(),
                domain.getEmail(),
                domain.getFavorito(),
                domain.getFoto(),
                null
        );
    }

    // Converte um AtendimentoEntity para um Atendimento (domínio)
    @Override
    public Atendimento toAtendimentoDomain(AtendimentoEntity entity) {
        Paciente paciente = partialToPacienteDomain(entity.getPaciente()); // Chamando método parcial para evitar recursão

        return new Atendimento(
                entity.getId(),
                entity.getDataAtendimento(),
                entity.getNomeProfissional(),
                entity.getEspecialidadeEnum(),
                entity.getRegistroAtendimento(),
                entity.getRetorno(),
                paciente
        );
    }

    @Override
    public AtendimentoEntity toAtendimentoEntity(Atendimento domain) {
        PacienteEntity pacienteEntity = toPacienteEntitySemAtendimento(domain.getPaciente());

        AtendimentoEntity entity = new AtendimentoEntity();
        entity.setId(domain.getId());
        entity.setDataAtendimento(domain.getDataAtendimento());
        entity.setNomeProfissional(domain.getNomeProfissional());
        entity.setEspecialidadeEnum(domain.getEspecialidade());
        entity.setRegistroAtendimento(domain.getRegistroAtendimento());
        entity.setRetorno(domain.getRetorno());
        entity.setPaciente(pacienteEntity);
        return entity;
    }

    private Atendimento partialToAtendimentoDomain(AtendimentoEntity entity) {
        return new Atendimento(
                entity.getId(),
                entity.getDataAtendimento(),
                entity.getNomeProfissional(),
                entity.getEspecialidadeEnum(),
                entity.getRegistroAtendimento(),
                entity.getRetorno(),
                null // Evitar conversão recursiva
        );
    }

    private Paciente partialToPacienteDomain(PacienteEntity entity) {
        return new Paciente(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getIdade(),
                entity.getEmail(),
                entity.getFavorito(),
                entity.getFoto(),
                null // Evitar conversão recursiva
        );
    }

    private AtendimentoEntity partialToAtendimentoEntity(Atendimento domain) {
        AtendimentoEntity entity = new AtendimentoEntity();
        entity.setId(domain.getId());
        entity.setDataAtendimento(domain.getDataAtendimento());
        entity.setNomeProfissional(domain.getNomeProfissional());
        entity.setEspecialidadeEnum(domain.getEspecialidade());
        entity.setRegistroAtendimento(domain.getRegistroAtendimento());
        entity.setRetorno(domain.getRetorno());
        // Não associar o paciente entidade para evitar recursão
        return entity;
    }
}