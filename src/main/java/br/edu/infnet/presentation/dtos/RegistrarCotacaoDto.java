package br.edu.infnet.presentation.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegistrarCotacaoDto {

    @NotNull
    private Double valor;

    @NotNull
    private Long idProduto;

    @NotNull
    @NotBlank
    private String nomeCliente;
}
