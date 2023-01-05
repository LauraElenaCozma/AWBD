package com.awbd.lab5.repositories;

import com.awbd.lab5.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findProducts() {
        List<Product> products = productRepository.findBySeller(1L);
        assertTrue(products.size() >= 1);
        log.info("findBySeller ...");
        products.forEach(product -> log.info(product.getName()));
    }

    @Test
    public void findProductsBySellerName() {
        List<Product> products = productRepository.findBySellerName("Will","Snow");
        assertTrue(products.size() >= 1);
        log.info("findBySeller ...");
        products.forEach(product -> log.info(product.getName()));
    }

    @Test
    public void findPage(){
        Pageable firstPage = PageRequest.of(0, 2);
        Page<Product> allProducts = productRepository.findAll(firstPage);
        assertTrue(allProducts.getNumberOfElements() == 2);
    }



}
