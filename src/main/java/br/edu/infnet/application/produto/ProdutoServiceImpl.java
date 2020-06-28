package br.edu.infnet.application.produto;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Fornecedor;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.infra.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    @Override
    public void registrarProduto(String nomeProduto, String fornecedor) {
        Produto produto = new Produto(nomeProduto, fornecedor);
        produtoRepository.save(produto);
    }

    @Override
    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarProdutosDeFornecedor(String nomeFornecedor) {
        return produtoRepository.findAllByFornecedor(new Fornecedor(nomeFornecedor));
    }

    @Override
    public Produto buscarProdutoPorId(UUID idProduto) throws ProdutoNaoEncontradoException {
        return produtoRepository.findById(idProduto)
                .orElseThrow(ProdutoNaoEncontradoException::new);
    }
}
