package com.github.joaovictorjpg.codeblack.services;

import com.github.joaovictorjpg.codeblack.model.entity.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Page<Product> getProducts(int page, int size);
    Product saveProduct(ProductDTO productDTO);
    Product getProduct(ProductDTO productDTO, Long id);
    Product showByTitle(String title);
    Product updateProduct(ProductDTO productDTO, Long id);
    void deleteProduct(Long id);

}
