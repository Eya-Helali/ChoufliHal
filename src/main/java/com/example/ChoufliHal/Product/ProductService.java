package com.example.ChoufliHal.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //TODO : get product lists with filters
    //TODO :pagination

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId); }

    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);

    }

    public Product addProduct(Product product) {
        return  productRepository.save(product);
    }

    public Product updateProductById(Product productUpdated, Long productId) {
        productUpdated.setProductId(productId);
        return productRepository.save(productUpdated);
    }
}
