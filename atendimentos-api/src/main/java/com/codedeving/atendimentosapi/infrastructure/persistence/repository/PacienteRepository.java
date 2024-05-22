package com.codedeving.atendimentosapi.infrastructure.persistence.repository;

import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    PacienteEntity findByEmail(String email);
}
