package br.edu.infnet.presentation.controllers;

import br.edu.infnet.application.cotacao.CotacaoService;
import br.edu.infnet.presentation.dtos.RegistrarCotacaoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cotacoes")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CotacoesController {

    private final CotacaoService cotacaoService;

    @GetMapping("/")
    private String listarCotacoes(ModelMap model) {
        model.addAttribute("cotacoes", cotacaoService.buscarCotacoes());
        return "/cotacoes/index";
    }

    @GetMapping("/novo")
    private String registrarCotacao(ModelMap model) {
        model.addAttribute("novaCotacao", new RegistrarCotacaoDto());
        return "/cotacoes/novo";
    }
}
