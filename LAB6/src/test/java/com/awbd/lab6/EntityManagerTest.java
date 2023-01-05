package com.awbd.lab6;

import com.awbd.lab6.domain.Currency;
import com.awbd.lab6.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void findProduct() {
        Product productFound = entityManager.find(Product.class, 1L);
        assertEquals(productFound.getCode(), "PCEZ");
    }

    @Test public void updateProduct() {
        Product productFound = entityManager.find(Product.class, 1L);
        productFound.setCurrency(Currency.USD); entityManager.persist(productFound); entityManager.flush();
    }

    @Test public void findCurrency() {
        Product productFound = entityManager.find(Product.class, 1L);
        assertEquals(productFound.getCurrency(),Currency.USD);
    }
}
