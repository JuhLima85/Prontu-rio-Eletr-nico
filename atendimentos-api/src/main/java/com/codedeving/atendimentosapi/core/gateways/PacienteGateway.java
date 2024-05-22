package com.codedeving.atendimentosapi.core.gateways;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import jakarta.servlet.http.Part;
import org.springframework.data.domain.Page;

public interface PacienteGateway {

    Paciente createPaciente(Paciente paciente);

    Paciente findByEmail(String email);

    void deletePaciente(Integer id);

    //List<Contato> obtainAllContatos();

    Page<Paciente> obtainAllPacientes(Integer pagina, Integer tamanhoPagina);

   Paciente obterPacientePorId(Integer id);

    void favoritePaciente(Integer id);

    Paciente updatePaciente(Integer id, Paciente paciente);

    byte[] addPhoto(Integer id, Part arquivo);
}