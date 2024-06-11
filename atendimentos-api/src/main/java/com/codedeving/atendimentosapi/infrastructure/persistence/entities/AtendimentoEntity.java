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
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtendimento;
    private String nomeProfissional;
    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidadeEnum;
    private String registroAtendimento;
    private LocalDate retorno;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @PrePersist
    public void prePersist() {
        setDataAtendimento(LocalDate.now());
    }
}
