package br.edu.infnet.domain;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    private UUID id;
    private String nome;

    @Embedded
    private Fornecedor fornecedor;

    public Produto(String nomeProduto, String nomeFornecedor) {
        this.id = UUID.randomUUID();
        this.nome = nomeProduto;
        this.fornecedor = new Fornecedor(nomeFornecedor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto produto = (Produto) o;

        return getId().equals(produto.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
