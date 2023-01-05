package com.awbd.lab5.Services;

import com.awbd.lab5.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long l);
    Product save(Product product);
    void deleteById(Long id);
}
