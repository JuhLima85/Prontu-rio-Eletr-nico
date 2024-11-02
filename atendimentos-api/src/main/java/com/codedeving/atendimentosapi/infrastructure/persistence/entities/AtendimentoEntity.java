package com.codedeving.atendimentosapi.infrastructure.persistence.entities;

import com.codedeving.atendimentosapi.core.domain.enums.EspecialidadeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_ATENDIMENTO")
public class AtendimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "ID", nullable = true)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtendimento;

    private String nomeProfissional;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidadeEnum;

    private String registroAtendimento;

    private LocalDate retorno;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = true)
    private PacienteEntity paciente;

    public AtendimentoEntity(Integer id, LocalDate dataAtendimento, String nomeProfissional, EspecialidadeEnum especialidadeEnum, String registroAtendimento, LocalDate retorno) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.nomeProfissional = nomeProfissional;
        this.especialidadeEnum = especialidadeEnum;
        this.registroAtendimento = registroAtendimento;
        this.retorno = retorno;
    }

    @PrePersist
    public void prePersist() {
        setDataAtendimento(LocalDate.now());
    }

    @Override
    public String toString() {
        return "AtendimentoEntity{" +
                "id=" + id +
                ", dataAtendimento=" + dataAtendimento +
                ", nomeProfissional='" + nomeProfissional + '\'' +
                ", especialidadeEnum=" + especialidadeEnum +
                ", registroAtendimento='" + registroAtendimento + '\'' +
                ", retorno=" + retorno +
                ", paciente=" + (paciente != null ? paciente.getId() : null) +
                '}';
    }
}
