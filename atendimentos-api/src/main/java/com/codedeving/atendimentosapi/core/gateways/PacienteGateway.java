package com.codedeving.atendimentosapi.core.gateways;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import jakarta.servlet.http.Part;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PacienteGateway {

    Paciente createPaciente(Paciente paciente);

    Optional<Paciente> findByCpf(String cpf);

    void deletePaciente(Integer id);

    Page<Paciente> obtainAllPacientes(Integer pagina, Integer tamanhoPagina);

   Optional<Paciente> findById(Integer id);

    void favoritePaciente(Integer id);

    Paciente updatePaciente(Integer id, Paciente paciente);

    byte[] addPhoto(Integer id, Part arquivo);
}