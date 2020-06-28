package br.edu.infnet.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "produtos")
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @Embedded
    private Fornecedor fornecedor;

    public Produto(String nomeProduto, String nomeFornecedor) {
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
