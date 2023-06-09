package com.github.joaovictorjpg.codeblack.services;

import com.github.joaovictorjpg.codeblack.model.entity.Product;
import com.github.joaovictorjpg.codeblack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        return productRepository.save(new Product(productDTO));
    }

    @Override
    public Product getProductById(ProductDTO productDTO, Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product showByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO, Long id) {

        Product productId = productRepository.findById(id).get();

        return productRepository.save(Product.builder()
                .id(productId.getId())
                .title(productDTO.title())
                .description(productDTO.description())
                .photo(productDTO.photo())
                .size(productDTO.size())
                .price(productDTO.price())
                .preparation(productDTO.preparation())
                .categoryId(productDTO.categoryEnum())
                .build());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
