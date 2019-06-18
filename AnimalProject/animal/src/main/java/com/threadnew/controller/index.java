package com.threadnew.controller;

import com.threadnew.pojo.Encyc;
import com.threadnew.service.EncycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    private EncycService service;
    @GetMapping("/home")
    public String home(){
        return service.get().toString();
    }
}
