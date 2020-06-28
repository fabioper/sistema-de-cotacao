package br.edu.infnet.application.produto;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    void registrarProduto(String nomeProduto, String fornecedor);

    List<Produto> buscarProdutos();

    List<Produto> buscarProdutosDeFornecedor(String nomeFornecedor);

    Produto buscarProdutoPorId(UUID idProduto) throws ProdutoNaoEncontradoException;

}
