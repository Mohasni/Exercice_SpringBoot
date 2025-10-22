package com.exercice.tp.service;

import com.exercice.tp.model.Category;
import com.exercice.tp.model.Product;
import com.exercice.tp.model.ProductDTO;
import com.exercice.tp.model.ProductMapper;
import com.exercice.tp.repository.CategooryRepository;
import com.exercice.tp.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final CategooryRepository categooryRepository;

    public List<ProductDTO> getProductByCategoryId(Long id){
        List<Product> products = productRepository.findByCategoryId(id);
        return products.stream().map(ProductMapper :: toDTO).toList();
    }

    public Page<Product> getProductByFiltre(Pageable page, String name){
       if (name == null || name.isBlank()){
           return productRepository.findAll(page);
       }
       return productRepository.findByNameContainingIgnoreCase(name, page);
    }

    public ProductDTO getProductById(Long id){
        Product products = productRepository.findById(id).orElse(null);
        return ProductMapper.toDTO(products);
    }

    public ProductDTO postProducts(ProductDTO productDTO) {
        Category category = categooryRepository.findById(productDTO.getCategory().getId()).orElse(null);
        Product product = ProductMapper.toEntity(productDTO);
        product.setCategory(category);
        product = productRepository.save(product);
        if (productDTO.getPrice() < 0 || productDTO.getStock() < 0) {
            throw new IllegalArgumentException("Price and stock < 0");
        }
        return ProductMapper.toDTO(product);
    }

    public ProductDTO putProduct( Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id).orElse(null);
        product.setId(id);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCategory(productDTO.getCategory());
        return ProductMapper.toDTO(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
