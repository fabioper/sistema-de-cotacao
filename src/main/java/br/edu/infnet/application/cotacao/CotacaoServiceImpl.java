package br.edu.infnet.application.cotacao;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Cotacao;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.infra.CotacaoRepository;
import br.edu.infnet.infra.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CotacaoServiceImpl implements CotacaoService {

    private final CotacaoRepository cotacaoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public void registrarCotacao(Long valorCotacao, Long idProduto, String nomeCliente) throws ProdutoNaoEncontradoException {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);

        Cotacao cotacao = new Cotacao(valorCotacao, produto, nomeCliente);

        cotacaoRepository.save(cotacao);
        produtoRepository.save(produto);
    }

    @Override
    public List<Cotacao> buscarCotacoes() {
        return cotacaoRepository.findAll();
    }
}
