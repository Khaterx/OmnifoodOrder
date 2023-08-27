package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.model.Country;
import com.omnifood.omnifoodorder.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class CountryController {
    @Autowired
    private CountryServices countryServices;

    @GetMapping("/getAllCountries")
    public List<Country> getAllCountries(){
        return countryServices.getAllCountries();
    }
}
