package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String index() {
        return "Hello World from docker deployed by jenkins cloned from github :)";
    }

    @GetMapping("/hi")
    public String index2() {
        return "Hello again world for an update from docker deployed by jenkins cloned from github :)";
    }
}