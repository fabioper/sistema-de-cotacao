package br.edu.infnet.application.produto;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.domain.Produto;

import java.util.List;

public interface ProdutoService {

    void registrarProduto(String nomeProduto, String fornecedor);

    List<Produto> buscarProdutos();

    List<Produto> buscarProdutosDeFornecedor(String nomeFornecedor);

    Produto buscarProdutoPorId(Long idProduto) throws ProdutoNaoEncontradoException;

}
