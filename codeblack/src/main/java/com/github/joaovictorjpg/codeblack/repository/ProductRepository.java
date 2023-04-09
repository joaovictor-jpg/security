package com.github.joaovictorjpg.codeblack.repository;

import com.github.joaovictorjpg.codeblack.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
    Optional<Product> findByCategoryId(Long categoryId);
}
