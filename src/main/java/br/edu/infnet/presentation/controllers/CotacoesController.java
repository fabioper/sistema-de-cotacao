package br.edu.infnet.presentation.controllers;

import br.edu.infnet.application.cotacao.CotacaoService;
import br.edu.infnet.application.exceptions.CotacaoNaoEncontradaException;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.application.produto.ProdutoService;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.presentation.dtos.RegistrarCotacaoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cotacoes")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CotacoesController {

    private final CotacaoService cotacaoService;
    private final ProdutoService produtoService;

    @GetMapping
    private String listarCotacoes(ModelMap model) {
        model.addAttribute("cotacoes", cotacaoService.buscarCotacoes());
        return "/cotacoes/index";
    }

    @GetMapping("/novo")
    private String registrarCotacao(ModelMap model) {
        model.addAttribute("produtosDisponiveis", produtoService.buscarProdutos());
        model.addAttribute("novaCotacao", new RegistrarCotacaoDto());
        return "/cotacoes/novo";
    }

    @PostMapping("/novo")
    private String registrarCotacao(@Valid @ModelAttribute("novaCotacao") RegistrarCotacaoDto novaCotacao,
                                    BindingResult result,
                                    ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("produtosDisponiveis", produtoService.buscarProdutos());
            return "/cotacoes/novo";
        }

        try {
            cotacaoService.registrarCotacao(novaCotacao.getValor(), novaCotacao.getIdProduto(), novaCotacao.getNomeCliente());
            return "redirect:/cotacoes";
        } catch (ProdutoNaoEncontradoException e) {
            model.addAttribute("error", e.getMessage());
            return "/cotacoes/novo";
        }
    }

    @GetMapping("/{id}/excluir")
    private String excluirCotacao(@PathVariable("id") Long idCotacao, ModelMap model) {
        try {
            cotacaoService.excluirCotacao(idCotacao);
            return "redirect:/cotacoes";
        } catch (CotacaoNaoEncontradaException e) {
            model.addAttribute("error", e.getMessage());
            return "/cotacoes/index";
        }
    }
}
