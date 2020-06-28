package br.edu.infnet.presentation.controllers;

import br.edu.infnet.application.cotacao.CotacaoService;
import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.application.produto.ProdutoService;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.presentation.dtos.RegistrarCotacaoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Produto> produtosDisponiveis = produtoService.buscarProdutos();
        model.addAttribute("produtosDisponiveis", produtosDisponiveis);
        model.addAttribute("novaCotacao", new RegistrarCotacaoDto());
        return "/cotacoes/novo";
    }

    @PostMapping("/novo")
    private String registrarCotacao(@Valid @ModelAttribute("novaCotacao") RegistrarCotacaoDto novaCotacao,
                                    BindingResult result) {
        if (result.hasErrors()) return "/cotacoes/novo";

        try {
            cotacaoService.registrarCotacao(novaCotacao.getValor(), novaCotacao.getIdProduto());
        } catch (ProdutoNaoEncontradoException e) {
            log.info("Produto <{}> não foi encontrado", novaCotacao.getIdProduto());
            e.printStackTrace();
        }

        return "redirect:/cotacoes";
    }
}
