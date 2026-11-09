package com.example.demo;

public class BusinessException extends RuntimeException {
    public enum Erro {
        IDADE_INVALIDA("A Idade deve ser maior que zero");

        private final String mensagem;
        Erro(String mensagem) {
            this.mensagem = mensagem;
        }
        public String getMensagem() {
            return mensagem;
        }
    }

    public BusinessException(Erro erro) {
        super(erro.getMensagem());
    }



}
