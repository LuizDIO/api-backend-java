package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class OlaController {

    List<Aluno> alunos = new ArrayList<>();

    public OlaController() {
        alunos.add(new Aluno(1L, "Pedro Abreu", "Pedro@email.com.br"));
    }

    @GetMapping("/alunos")
    public List<Aluno> listarAlunos() {
        return alunos;
    }


}
