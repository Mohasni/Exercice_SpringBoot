package com.exercice.tp.service;

import com.exercice.tp.model.Category;
import com.exercice.tp.model.CategoryDTO;
import com.exercice.tp.model.CategoryMapper;
import com.exercice.tp.repository.CategooryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategorySevice {
    private final CategooryRepository categooryRepository;

    public List<CategoryDTO> getCategory(){
        List<Category> category = categooryRepository.findAll();
        return category.stream().map(CategoryMapper :: toDTO).toList();
    }

    public CategoryDTO postCategory(CategoryDTO categoryCDO){
        Category category = CategoryMapper.toEntity(categoryCDO);
        category = categooryRepository.save(category);
        return CategoryMapper.toDTO(category);
    }
}
