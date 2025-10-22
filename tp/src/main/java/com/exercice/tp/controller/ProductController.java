package com.exercice.tp.controller;

import com.exercice.tp.model.Category;
import com.exercice.tp.model.Product;
import com.exercice.tp.model.ProductDTO;
import com.exercice.tp.model.ProductMapper;
import com.exercice.tp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private  final ProductService productService;

    @GetMapping("/categories/{id}/products")
    public List<ProductDTO> getProductByCategoryId(@PathVariable Long id){
      return productService.getProductByCategoryId(id);
    }
    @GetMapping("/products")
    public Page<Product> list(@RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size, @RequestParam(defaultValue="id,asc") String sort, @RequestParam(required=false) String name) {
        String[] s = sort.split(",");
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(s[1]), s[0]));
        return productService.getProductByFiltre(pageable, name);
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping("/products")
    public ProductDTO postProduct(@RequestBody ProductDTO productDTO){
        return productService.postProducts(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO putProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.putProduct(id, productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}

