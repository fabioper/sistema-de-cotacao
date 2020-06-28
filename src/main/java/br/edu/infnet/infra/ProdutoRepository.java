package br.edu.infnet.infra;

import br.edu.infnet.domain.Fornecedor;
import br.edu.infnet.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

    List<Produto> findAll();

    Optional<Produto> findById(UUID id);

    List<Produto> findAllByFornecedor(Fornecedor fornecedor);
}
