package com.awbd.lab5.Services;

import com.awbd.lab5.domain.Product;
import com.awbd.lab5.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> products = new LinkedList<>();
        // iteram ce vine din repository si adaugam in lista returnata
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    @Override
    public Product findById(Long l) {
        Optional<Product> productOptional = productRepository.findById(l);
        if(!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }

    @Override
    public Product save(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
