package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final List<AlunoModel> alunos = new ArrayList<>();

    public List<AlunoModel> listarAlunos() {
        return alunos;
    }

    public AlunoModel cadastrar(AlunoModel aluno) {
        alunos.add(aluno);
        return aluno;
    }

    public AlunoModel editar(Long id, AlunoModel dadosNovos) {

        for (AlunoModel aluno : alunos) {
            if (aluno.getId().equals(id)) {
                if (aluno.getNome() != null) {
                    aluno.setNome(dadosNovos.nome);
                }
                if (aluno.getEmail() != null) {
                    aluno.setEmail(dadosNovos.email);
                }
                if (aluno.getIdade() != null) {
                    aluno.setIdade(dadosNovos.idade);
                }

                return aluno;
            }
        }
        return null;
    }

    public boolean excluir(Long id) {
        return alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
