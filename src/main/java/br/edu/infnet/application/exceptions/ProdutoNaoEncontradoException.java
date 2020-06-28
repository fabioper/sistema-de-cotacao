package br.edu.infnet.application.exceptions;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado");
    }
}
