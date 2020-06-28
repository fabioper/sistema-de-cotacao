package br.edu.infnet.application.exceptions;

public class CotacaoNaoEncontradaException extends Exception {
    public CotacaoNaoEncontradaException() {
        super("Cotação não encontrada");
    }
}
