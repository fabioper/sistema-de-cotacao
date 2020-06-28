package br.edu.infnet.application.cotacao;

import br.edu.infnet.application.exceptions.CotacaoNaoEncontradaException;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Cotacao;

import java.util.List;
import java.util.UUID;

public interface CotacaoService {

    void registrarCotacao(Long valorCotacao, UUID idProduto) throws ProdutoNaoEncontradoException;

    List<Cotacao> buscarCotacoes();

    Cotacao buscarCotacaoPorId(UUID idCotacao) throws CotacaoNaoEncontradaException;

    List<Cotacao> buscarCotacaoPorProduto(UUID idProduto) throws ProdutoNaoEncontradoException;
}
