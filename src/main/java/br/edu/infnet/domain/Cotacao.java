package br.edu.infnet.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cotacoes")
public class Cotacao implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long valor;
    private Cliente cliente;

    @ManyToOne
    private Produto produto;

    private LocalDate dataCotacao;

    public Cotacao(Long valor, Produto produto, String nomeCliente) {
        this.valor = valor;
        this.produto = produto;
        this.cliente = new Cliente(nomeCliente);
        this.dataCotacao = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cotacao)) return false;

        Cotacao cotacao = (Cotacao) o;

        return getId().equals(cotacao.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
