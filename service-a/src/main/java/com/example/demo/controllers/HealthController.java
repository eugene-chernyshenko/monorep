package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
class HealthController {

    @Autowired
    private Environment env;

    @GetMapping
    public String health() {
        return "foo: " + env.getProperty("foo") + ", bar: " + env.getProperty("bar");
    }
}
