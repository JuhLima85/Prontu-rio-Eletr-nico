package com.codedeving.atendimentosapi.infrastructure.persistence.repository;

import com.codedeving.atendimentosapi.infrastructure.persistence.entities.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Integer> {

}
