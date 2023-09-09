package com.example.lab4gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String paginaPrincipal(){
        return "Mensaje motivador: Siuuu";
    }
}
