package br.edu.infnet.presentation.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistrarProdutoDto {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String fornecedor;
}
