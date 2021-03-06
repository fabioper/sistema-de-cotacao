package br.edu.infnet.presentation.controllers;

import br.edu.infnet.application.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.application.produto.ProdutoService;
import br.edu.infnet.presentation.dtos.RegistrarProdutoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/produtos")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class ProdutosController {

    private final ProdutoService produtoService;

    @GetMapping
    private String listarProdutos(ModelMap model) {
        model.addAttribute("produtos", produtoService.buscarProdutos());
        return "/produtos/index";
    }

    @GetMapping("/novo")
    private String registrarProduto(ModelMap model) {
        model.addAttribute("novoProduto", new RegistrarProdutoDto());
        return "/produtos/novo";
    }

    @PostMapping("/novo")
    private String registrarProduto(@Valid @ModelAttribute("novoProduto") RegistrarProdutoDto novoProduto,
                                    BindingResult result) {
        if (result.hasErrors()) return "/produtos/novo";

        produtoService.registrarProduto(novoProduto.getNome(), novoProduto.getFornecedor());
        return "redirect:/produtos";
    }

    @GetMapping("/{id}/excluir")
    private String excluirProduto(@PathVariable("id") Long idProduto, ModelMap model) {
        try {
            produtoService.excluirProduto(idProduto);
            return "redirect:/produtos";
        } catch (ProdutoNaoEncontradoException e) {
            model.addAttribute("error", e.getMessage());
            return "/produtos/index";
        }
    }
}
