package com.exercice.tp.model;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory()
        );
    }

    public static Product toEntity(ProductDTO productDTO){
        return new Product(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getStock(),
                productDTO.getCategory()
        );
    }
}





