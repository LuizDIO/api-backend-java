package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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


    public AlunoModel cadastrar(AlunoModel aluno) {
        if (aluno.getIdade() == null || aluno.getIdade() <= 0) {
            throw new IllegalArgumentException("Idade Invalida");
        }
        return alunoRepository.save(aluno);
    }


    @Transactional
    public AlunoModel editar(Long id, AlunoModel alunoModel) {

        AlunoModel aluno = alunoRepository.findById(id).orElse(null);
            if (aluno == null ) {
                return null;
            }
            if (alunoModel.getNome() != null ) {
                aluno.setNome(alunoModel.getNome());
            }
            if (alunoModel.getEmail() != null) {
                aluno.setEmail(alunoModel.getEmail());
            }
            if (alunoModel.getIdade() != null) {
                aluno.setIdade((alunoModel.getIdade()));
            }

            return aluno;

        }


    public boolean excluir(Long id) {
        boolean existe = alunoRepository.existsById(id);

        if (!existe) {
            return false;
        }

        alunoRepository.deleteById(id);
        return true;
    }
}
