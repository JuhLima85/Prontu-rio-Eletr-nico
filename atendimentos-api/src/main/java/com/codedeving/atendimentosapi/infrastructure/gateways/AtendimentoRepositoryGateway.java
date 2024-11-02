package com.codedeving.atendimentosapi.infrastructure.gateways;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;
import com.codedeving.atendimentosapi.infrastructure.converters.EntityMapperImpl;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.repository.AtendimentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AtendimentoRepositoryGateway implements AtendimentoGateway {

    @PersistenceContext
    private EntityManager entityManager;
    private final AtendimentoRepository atendimentoRepository;
    private final EntityMapperImpl mapper;

    @Override
    public Atendimento createAtendimento(Integer pacienteId, Atendimento atendimento) {
        PacienteEntity pacienteEntity = entityManager.getReference(PacienteEntity.class, pacienteId);
        AtendimentoEntity atendimentoEntity = mapper.toAtendimentoEntity(atendimento);
        atendimentoEntity.setPaciente(pacienteEntity);
        AtendimentoEntity novoAtendimentoEntity  = atendimentoRepository.save(atendimentoEntity);
        return mapper.toAtendimentoDomain(novoAtendimentoEntity);
    }

    @Override
    public Optional<Atendimento> findById(Integer id) {
        return atendimentoRepository
                .findById(id)
                .map(mapper::toAtendimentoDomain);
    }

    @Override
    public Page<Atendimento> obtainAllAtendimentos(Integer pagina, Integer tamanhoPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "dataAtendimento");
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
        return atendimentoRepository
                .findAll(pageRequest)
                .map(mapper::toAtendimentoDomain);
    }

    @Override
    public Atendimento updateAtendimento(Integer id, Atendimento atendimento) {
        System.out.println("AtendimentoRepositoryGateway - update: " + atendimento);
        AtendimentoEntity atendimentoEntity = mapper.toAtendimentoEntity(atendimento);
        AtendimentoEntity updatedEntity  = atendimentoRepository.save(atendimentoEntity);
        return mapper.toAtendimentoDomain(updatedEntity );
    }

    @Transactional
    @Override
    public void deleteAtendimento(Integer id) {
        AtendimentoEntity atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new AtendimentoNotFoundException());

        // Remover atendimento da lista de atendimentos do paciente
        if (atendimento.getPaciente() != null) {
            atendimento.getPaciente().getAtendimentos().remove(atendimento);
        }

        // Agora excluir o atendimento
        atendimentoRepository.deleteById(id);
        atendimentoRepository.flush();
    }
}