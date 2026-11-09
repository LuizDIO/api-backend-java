package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class AlunoService {

    //Registro de log com erros
    private static final Logger log = LoggerFactory.getLogger(AlunoService.class);

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> listarAlunos() {
        return alunoRepository.findAll();
    }


    public List<AlunoModel> cadastrar(List<AlunoModel> alunos) {
        for (AlunoModel aluno : alunos) {
        if (aluno.getIdade() == null || aluno.getIdade() <= 0) {
            log.error("Idade invalida para o aluno: {}", aluno.getId());

            throw new BusinessException(BusinessException.Erro.IDADE_INVALIDA);

        }
        }
        return alunoRepository.saveAll(alunos);
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
