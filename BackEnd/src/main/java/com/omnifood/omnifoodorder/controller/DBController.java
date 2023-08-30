package com.omnifood.omnifoodorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DBController {

    @GetMapping("/data")
    public String getDate() {
        return "my Data 🎉";
    }

    @GetMapping("/useradmin")
    public String userAdmin() {
        return "Hello User || Admin 👋";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin 👋😎";
    }
}
