package com.codedeving.atendimentosapi.infrastructure.gateways;

import com.codedeving.atendimentosapi.core.domain.Paciente;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;
import com.codedeving.atendimentosapi.infrastructure.converters.PacienteEntityMapper;
import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.infrastructure.persistence.entities.PacienteEntity;
import com.codedeving.atendimentosapi.infrastructure.persistence.repository.PacienteRepository;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PacienteRepositoryGateway implements PacienteGateway {

    private final PacienteRepository pacienteRepository;
    private final PacienteEntityMapper entityMapper;

    @Override
    public Paciente createPaciente(Paciente paciente) {
        PacienteEntity entity = entityMapper.toEntity(paciente);
        PacienteEntity novoPaciente = pacienteRepository.save(entity);
        return entityMapper.toPaciente(novoPaciente);
    }

    @Override
    public Optional<Paciente> findByCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf).map(entityMapper::toPaciente);
    }

    @Override
    public void deletePaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Page<Paciente> obtainAllPacientes(Integer pagina, Integer tamanhoPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
        return pacienteRepository
                .findAll(pageRequest)
                .map(entityMapper::toPaciente);
    }

    @Override
    public  Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id)
                .map(entityMapper::toPaciente);
    }

    @Override
    public void favoritePaciente(Integer id) {
        Optional<PacienteEntity> contatoEntity = pacienteRepository.findById(id);
        contatoEntity.ifPresent(c -> {
            boolean favorito = c.getFavorito() == Boolean.TRUE;
            c.setFavorito(!favorito);
            pacienteRepository.save(c);
        });
    }

    @Override
    public Paciente updatePaciente(Integer id, Paciente paciente) {
        PacienteEntity entity = entityMapper.toEntity(paciente);

        PacienteEntity existingEntity = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente não encontrado"));

        existingEntity.setNome(entity.getNome());
        existingEntity.setEmail(entity.getEmail());
        existingEntity.setFavorito(entity.getFavorito());

        PacienteEntity pacienteUpdate = pacienteRepository.save(existingEntity);
        return entityMapper.toPaciente(pacienteUpdate);
    }

    @Override
    public byte[] addPhoto(Integer id, Part arquivo) {
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(id);
       return pacienteEntity.map( c -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setFoto(bytes);
                pacienteRepository.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElse(null);
    }
}
