package br.edu.infnet.application.cotacao;

import br.edu.infnet.application.exceptions.CotacaoNaoEncontradaException;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Cotacao;

import java.util.List;

public interface CotacaoService {

    void registrarCotacao(Long valorCotacao, Long idProduto) throws ProdutoNaoEncontradoException;

    List<Cotacao> buscarCotacoes();

    Cotacao buscarCotacaoPorId(Long idCotacao) throws CotacaoNaoEncontradaException;

    List<Cotacao> buscarCotacaoPorProduto(Long idProduto) throws ProdutoNaoEncontradoException;
}
