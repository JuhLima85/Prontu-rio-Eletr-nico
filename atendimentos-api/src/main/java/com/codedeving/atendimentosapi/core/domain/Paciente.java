package com.codedeving.atendimentosapi.core.domain;

import java.util.Arrays;
import java.util.List;

public class Paciente {
    private Integer id;
    private String nome;
    private String cpf;
    private String idade;
    private String email;
    private Boolean favorito;
    private byte[] foto;
    private List<Atendimento> atendimentos;

    public Paciente() {

    }

    public Paciente(Integer id) {
        this.id = id;
    }
    public Paciente(Integer id, String nome, String cpf, String idade, String email, Boolean favorito, byte[] foto, List<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.favorito = favorito;
        this.foto = foto;
        this.atendimentos = atendimentos;
    }

    public Paciente(Integer id, String nome, String cpf, String idade, String email, Boolean favorito, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.favorito = favorito;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade='" + idade + '\'' +
                ", email='" + email + '\'' +
                ", favorito=" + favorito +
                ", foto=" + Arrays.toString(foto) +
                ", atendimentos=" + atendimentos +
                '}';
    }
}