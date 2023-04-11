package com.github.joaovictorjpg.codeblack.controller;

import com.github.joaovictorjpg.codeblack.model.entity.Product;
import com.github.joaovictorjpg.codeblack.services.ProductDTO;
import com.github.joaovictorjpg.codeblack.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> Index(@RequestParam int page, @RequestParam int size) {

        Page<Product> data = productService.getProducts(page, size);
        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> Index(ProductDTO productDTO, @PathVariable Long id) {
        return ResponseEntity.ok().body(productService.getProductById(productDTO,id));
    }

    @GetMapping("/product/title/{title}")
    public ResponseEntity<Product> Index(ProductDTO productDTO, @PathVariable String title) {
        return ResponseEntity.ok().body(productService.showByTitle(title));
    }

    @PostMapping("/product/save")
    public ResponseEntity<Product> post(@RequestBody @Valid ProductDTO productDTO) {

        Product product = productService.saveProduct(productDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping("/product/update/{id}")
    @Transactional
    public ResponseEntity<Product> post(@RequestBody @Valid ProductDTO productDTO, @PathVariable Long id)  {

        Product product = productService.updateProduct(productDTO, id);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
