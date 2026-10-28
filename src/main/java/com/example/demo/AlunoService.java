package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    public Aluno cadastrar(Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    public Aluno editar(Long id, Aluno dadosNovos) {

        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                aluno.setNome(dadosNovos.getNome());
                aluno.setEmail(dadosNovos.getEmail());
                aluno.setIdade(dadosNovos.getIdade());

                return aluno;
            }
        }
        return null;
    }

    public boolean excluir (Long id) {
        return alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
