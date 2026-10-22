package com.example.demo;

public class Aluno {
    Long id;
    String nome;
    String email;

    public Aluno(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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
}

