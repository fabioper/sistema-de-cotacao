package br.edu.infnet.infra;

import br.edu.infnet.domain.Cotacao;
import br.edu.infnet.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, UUID> {

    List<Cotacao> findAll();

    List<Cotacao> findCotacaoByProduto(Produto produto);
}
