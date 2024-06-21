package com.codedeving.atendimentosapi.infrastructure.controllers;

import com.codedeving.atendimentosapi.core.domain.Atendimento;
import com.codedeving.atendimentosapi.core.usecases.atendimento.*;
//import com.codedeving.atendimentosapi.infrastructure.converters.AtendimentoDtoMapper;
import com.codedeving.atendimentosapi.infrastructure.converters.DtoMapper;
import com.codedeving.atendimentosapi.infrastructure.dtos.AtendimentoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    //private final AtendimentoDtoMapper atendimentoDtoMapper;
    private final DtoMapper mapper;
    private final CreateAtendimentoUseCase createAtendimentoUseCase;
    private final GetAllAtendimentosUseCase getAllAtendimentosUseCase;
    private final GetAtendimentoByIdUseCase getAtendimentoByIdUseCase;
    private final DeleteAtendimentoUseCase deleteAtendimentoUseCase;
    private final UpdateAtendimentoUseCase updateAtendimentoUseCase;

    @PostMapping("/{pacienteId}")
    public AtendimentoDto createAtendimento(@PathVariable Integer pacienteId, @RequestBody AtendimentoDto atendimentoDto) {
                Atendimento atendimento = createAtendimentoUseCase.execute(pacienteId, mapper.toAtendimentoDomain(atendimentoDto));
                System.out.println("FINAL CONTROLLER ====> " + atendimento );
        return mapper.toAtendimentoDto(atendimento);
    }

    @GetMapping
    public Page<AtendimentoDto> obtainAll(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
                                          @RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {
        return getAllAtendimentosUseCase.execute(pagina, tamanhoPagina)
                .map(mapper::toAtendimentoDto);
    }

//    @GetMapping("/{id}")
//    public AtendimentoDto buscarAtendimento(@PathVariable Integer id) {
//        Atendimento atendimento = getAtendimentoByIdUseCase.execute(id);
//        return atendimentoDtoMapper.toDTO(atendimento);
//    }

    @GetMapping("/{id}")
    public AtendimentoDto buscarAtendimento(@PathVariable Integer id) {
        Atendimento atendimento = getAtendimentoByIdUseCase.execute(id);
        AtendimentoDto atendimentoDto =  mapper.toAtendimentoDto(atendimento);
        System.out.println("CONTROLLER ATENDIMENTO------>" + atendimentoDto);
        return atendimentoDto;
    }

    @DeleteMapping("/{id}")
    public void deleteAtendimento(@PathVariable Integer id) {
        deleteAtendimentoUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public AtendimentoDto updateAtendimento(@PathVariable Integer id, @RequestBody AtendimentoDto atendimentoDto) {
        Atendimento atualizado = updateAtendimentoUseCase.execute(id, mapper.toAtendimentoDomain(atendimentoDto));
        return mapper.toAtendimentoDto(atualizado);
    }
}
