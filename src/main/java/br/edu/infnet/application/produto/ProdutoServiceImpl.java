package br.edu.infnet.application.produto;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Fornecedor;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.infra.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public void registrarProduto(String nomeProduto, String fornecedor) {
        Produto produto = new Produto(nomeProduto, fornecedor);
        produtoRepository.save(produto);
    }

    @Override
    public List<Produto> buscarProdutos() {
        log.info("!!! Buscando produtos...");
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarProdutosDeFornecedor(String nomeFornecedor) {
        return produtoRepository.findAllByFornecedor(new Fornecedor(nomeFornecedor));
    }

    @Override
    public Produto buscarProdutoPorId(Long idProduto) throws ProdutoNaoEncontradoException {
        return produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);
    }

    @Override
    public void excluirProduto(Long idProduto) throws ProdutoNaoEncontradoException {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);
        produtoRepository.delete(produto);
    }
}
