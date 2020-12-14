package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping // URL: http://localhost:8080 - caminho não especificado, mapeia para a raiz
    public String get(){
        return "Get Spring Boot";
    }

    @GetMapping("/login1") // URL: http://localhost:8080/login1?login=geyzen&senha=123 - não usa GET para senhas
    public String loginByRequestParam(@RequestParam("login") String login, @RequestParam("senha") String senha){
        return "Login: " + login + " - Senha: " + senha;
    }

    @GetMapping("/login2/{login}/senha/{senha}") // URL: http://localhost:8080/login2/geyzen/senha/123
    public String loginPath(@PathVariable("login") String login, @PathVariable("senha") String senha){
        return "Login: " + login + " - Senha: " + senha;
    }

    @PostMapping("/login3") // URL: http://localhost:8080/login3 - Navegador não aceita post, usar Postman
    public String postLogin(@RequestParam("login") String login, @RequestParam("senha") String senha){
        return "Login: " + login + " - Senha: " + senha;
    }

}
