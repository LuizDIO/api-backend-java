package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

    @GetMapping("/api/ola")
    public String ola() {
        return "Oi Pedro, tudo bem?";
    }
}

