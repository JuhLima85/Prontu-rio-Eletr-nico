package com.codedeving.atendimentosapi.core.domain;

import com.codedeving.atendimentosapi.core.domain.enums.EspecialidadeEnum;

import java.time.LocalDate;

public class Atendimento {
    private Integer id;
    private LocalDate dataAtendimento;
    private String nomeProfissional;
    private EspecialidadeEnum especialidadeEnum;
    private String registroAtendimento;
    private LocalDate retorno;
    private Paciente paciente;

    public Atendimento(Integer id, LocalDate dataAtendimento, String nomeProfissional, EspecialidadeEnum especialidadeEnum, String registroAtendimento, LocalDate retorno, Paciente paciente) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.nomeProfissional = nomeProfissional;
        this.especialidadeEnum = especialidadeEnum;
        this.registroAtendimento = registroAtendimento;
        this.retorno = retorno;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidadeEnum;
    }

    public void setEspecialidade(EspecialidadeEnum especialidadeEnum) {
        this.especialidadeEnum = especialidadeEnum;
    }

    public String getRegistroAtendimento() {
        return registroAtendimento;
    }

    public void setRegistroAtendimento(String registroAtendimento) {
        this.registroAtendimento = registroAtendimento;
    }

    public LocalDate getRetorno() {
        return retorno;
    }

    public void setRetorno(LocalDate retorno) {
        this.retorno = retorno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
