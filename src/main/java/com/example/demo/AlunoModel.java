package com.example.demo;

public class Aluno {
    Long id;
    String nome;
    String email;
    Integer idade;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String email, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}

