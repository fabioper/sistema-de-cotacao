package br.edu.infnet.presentation.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RegistrarCotacaoDto {

    @NotNull
    @Min(0)
    private Long valor;

    @NotNull
    private Long idProduto;
}
