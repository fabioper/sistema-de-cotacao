package br.edu.infnet.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Fornecedor {

    private String nomeFornecedor;

    public Fornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;

        Fornecedor that = (Fornecedor) o;

        return getNomeFornecedor().equals(that.getNomeFornecedor());
    }

    @Override
    public int hashCode() {
        return getNomeFornecedor().hashCode();
    }
}
