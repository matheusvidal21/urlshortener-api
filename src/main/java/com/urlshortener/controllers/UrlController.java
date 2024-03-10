package com.urlshortener.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {

    @PostMapping("create-short")
    public String convertToShortUrl(@RequestBody ){
        return "";
    }

    @GetMapping
    public String getAndRedirect(){
        return "teste";
    }

}
