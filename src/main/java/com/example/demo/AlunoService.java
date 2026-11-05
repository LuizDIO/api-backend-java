package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }

    private  Long proximoId = 1L;

    public AlunoModel cadastrar(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }

    public AlunoModel editar(Long id, AlunoModel alunoModel) {

        for (AlunoModel aluno : alunos) {
            if (aluno.getId().equals(id)) {
                if (alunoModel.getNome() != null) {
                    aluno.setNome(alunoModel.getNome());
                }
                if (alunoModel.getEmail() != null) {
                    aluno.setEmail(alunoModel.getEmail());
                }
                if (alunoModel.getIdade() != null) {
                    aluno.setIdade(alunoModel.getIdade());
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
