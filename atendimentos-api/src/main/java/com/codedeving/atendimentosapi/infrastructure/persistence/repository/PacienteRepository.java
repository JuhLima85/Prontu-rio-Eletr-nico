package com.codedeving.atendimentosapi.infrastructure.persistence.repository;

import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    Optional<PacienteEntity> findByCpf(String cpf);
}
