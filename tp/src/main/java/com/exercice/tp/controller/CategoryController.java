package com.exercice.tp.controller;

import com.exercice.tp.model.CategoryDTO;
import com.exercice.tp.service.CategorySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategorySevice categorySevice;

    @GetMapping
    public List<CategoryDTO> getCategory(){
        return categorySevice.getCategory();
    }

    @PostMapping
    public CategoryDTO postCategory(@RequestBody CategoryDTO categoryCDO){
        return categorySevice.postCategory(categoryCDO);
    }
}


