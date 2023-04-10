package com.github.joaovictorjpg.codeblack.model.entity;

import com.github.joaovictorjpg.codeblack.model.Enum.CategoryEnum;
import com.github.joaovictorjpg.codeblack.services.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String photo;
    private Integer size;
    private BigDecimal price;
    private Integer preparation;
    private CategoryEnum categoryId;

    public Product(ProductDTO productDTO) {
        this.title = productDTO.getTitle();
        this.description = productDTO.getDescription();
        this.photo = productDTO.getPhoto();
        this.size = productDTO.getSize();
        this.price = productDTO.getPrice();
        this.preparation = productDTO.getPreparation();
        this.categoryId = productDTO.getCategoryEnum();
    }
}
