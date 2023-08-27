package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class CountryController {
    @Autowired
    private CountryServices countryServices;
}
