package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.CategoryRepository;
import com.omnifood.omnifoodorder.model.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
