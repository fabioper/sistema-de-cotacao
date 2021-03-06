package br.edu.infnet.application.cotacao;

import br.edu.infnet.application.exceptions.CotacaoNaoEncontradaException;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Cotacao;

import java.util.List;

public interface CotacaoService {

    void registrarCotacao(Double valorCotacao, Long idProduto, String nomeCliente) throws ProdutoNaoEncontradoException;

    List<Cotacao> buscarCotacoes();

    void excluirCotacao(Long idCotacao) throws CotacaoNaoEncontradaException;
}
