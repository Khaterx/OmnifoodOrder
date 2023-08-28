package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.model.Category;
import com.omnifood.omnifoodorder.services.CategoryServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return categoryServices.getAllCategories();
    }
}
