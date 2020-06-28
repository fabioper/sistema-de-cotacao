package br.edu.infnet.presentation.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "redirect:/cotacoes/";
    }
}
