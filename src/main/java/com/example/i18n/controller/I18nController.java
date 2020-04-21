package com.example.i18n.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nController extends BasicController {

    @GetMapping(value = "/getMessage")
    public String message(){
        return this.i18n("language");
    }
}
