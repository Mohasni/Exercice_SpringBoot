package com.exercice.tp.model;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category){
       return new CategoryDTO(
               category.getName()
       );
    }

    public static Category toEntity(CategoryDTO categoryCDO){
        return new Category(
                categoryCDO.getName()
        );
    }
}


