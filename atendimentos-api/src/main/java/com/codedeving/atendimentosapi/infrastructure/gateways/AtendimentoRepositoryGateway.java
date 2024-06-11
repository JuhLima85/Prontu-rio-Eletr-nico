package com.codedeving.atendimentosapi.infrastructure.gateways;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.exceptions.AtendimentoNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.AtendimentoGateway;
import com.codedeving.atendimentosapi.infrastructure.converters.AtendimentoEntityMapper;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.repository.AtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class AtendimentoRepositoryGateway implements AtendimentoGateway {

    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoEntityMapper entityMapper;

    @Override
    public Atendimento createAtendimento(Integer pacienteId, Atendimento atendimento) {
        AtendimentoEntity atendimentoEntity = entityMapper.toEntity(atendimento);
        AtendimentoEntity novoAtendimento = atendimentoRepository.save(atendimentoEntity);
        return entityMapper.toAtendimento(novoAtendimento);
    }

//    @Override
//    public Atendimento findById(Integer id) {
//        return atendimentoRepository
//                .findById(id)
//                .map(entityMapper::toAtendimento)
//                .orElseThrow(() -> new AtendimentoNotFoundException());
//    }

    @Override
    public Optional<Atendimento> findById(Integer id) {
        return atendimentoRepository
                .findById(id)
                .map(entityMapper::toAtendimento);
    }

    @Override
    public Page<Atendimento> obtainAllAtendimentos(Integer pagina, Integer tamanhoPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "dataAtendimento");
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
        return atendimentoRepository
                .findAll(pageRequest)
                .map(entityMapper::toAtendimento);
    }

    @Override
    public Atendimento updateAtendimento(Integer id, Atendimento atendimento) {
        AtendimentoEntity atendimentoEntity = entityMapper.toEntity(atendimento);
        AtendimentoEntity updatedEntity  = atendimentoRepository.save(atendimentoEntity);
        return entityMapper.toAtendimento(updatedEntity );
    }

    @Override
    public void deleteAtendimento(Integer id) {
       atendimentoRepository.deleteById(id);
    }



}
