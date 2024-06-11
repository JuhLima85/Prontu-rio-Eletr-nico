package com.codedeving.atendimentosapi.infrastructure.controllers;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.usecases.paciente.*;
import com.codedeving.atendimentosapi.infrastructure.converters.PacienteDtoMapper;
import com.codedeving.atendimentosapi.infrastructure.dtos.PacienteDto;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pacientes")
@AllArgsConstructor
public class PacienteController {

    private final CreatePacienteUseCase createPacienteUseCase;
    private final PacienteDtoMapper pacienteDtoMapper;
    private final DeletePacienteUseCase deletePacienteUseCase;
    private final GetAllPacienteUseCase getAllPacienteUseCase;
    private final FavoritePacienteUseCase favoritePacienteUseCase;
    private final UpdatePacienteUseCase updatePacienteUseCase;
    private final AddPhotoUseCase addPhotoUseCase;
    private final GetPacienteByIdUseCase getPacienteByIdUseCase;

    @PostMapping
    public PacienteDto createPaciente(@RequestBody PacienteDto pacienteDto){
        Paciente paciente = createPacienteUseCase.execute(pacienteDtoMapper.toDomain(pacienteDto));
        return pacienteDtoMapper.toDTO(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Integer id){
        deletePacienteUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public PacienteDto buscarPaciente(@PathVariable Integer id){
        Paciente paciente = getPacienteByIdUseCase.execute(id);
        return pacienteDtoMapper.toDTO(paciente);
    }
    @GetMapping
    public Page<PacienteDto> obtainAll(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
                                       @RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {
        //PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
        return getAllPacienteUseCase.execute(pagina, tamanhoPagina)
                .map(pacienteDtoMapper::toDTO);
    }

    @PatchMapping("/{id}/favorito")
    public void favorite(@PathVariable Integer id){
        favoritePacienteUseCase.execute(id);
    }

    @PutMapping("{id}")
    public PacienteDto updatePaciente(@PathVariable Integer id, @RequestBody PacienteDto pacienteDto){
        Paciente paciente = updatePacienteUseCase.execute(id, pacienteDtoMapper.toDomain(pacienteDto));
        return pacienteDtoMapper.toDTO(paciente);
    }

    @PutMapping("{id}/foto")
    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo){
        return addPhotoUseCase.execute(id, arquivo);
    }

}
