package br.edu.infnet.application.cotacao;

import br.edu.infnet.application.exceptions.CotacaoNaoEncontradaException;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Cotacao;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.infra.CotacaoRepository;
import br.edu.infnet.infra.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CotacaoServiceImpl implements CotacaoService {

    private final CotacaoRepository cotacaoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public void registrarCotacao(Long valorCotacao, UUID idProduto) throws ProdutoNaoEncontradoException {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);

        Cotacao cotacao = new Cotacao(valorCotacao, produto);

        cotacaoRepository.save(cotacao);
        produtoRepository.save(produto);
    }

    @Override
    public List<Cotacao> buscarCotacoes() {
        return cotacaoRepository.findAll();
    }

    @Override
    public Cotacao buscarCotacaoPorId(UUID idCotacao) throws CotacaoNaoEncontradaException {
        return cotacaoRepository.findById(idCotacao)
                .orElseThrow(CotacaoNaoEncontradaException::new);
    }

    @Override
    public List<Cotacao> buscarCotacaoPorProduto(UUID idProduto) throws ProdutoNaoEncontradoException {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);
        return cotacaoRepository.findCotacaoByProduto(produto);
    }
}
