package com.awbd.lab5;

import com.awbd.lab5.domain.Currency;
import com.awbd.lab5.domain.Participant;
import com.awbd.lab5.domain.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import java.util.Arrays;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CascadeTypeTest {
    @Autowired private EntityManager entityManager;

    @Test
    @Order(1)
    public void saveParticipant() {
        Participant participant = new Participant();
        participant.setFirstName("Will");
        participant.setLastName("Snow");
        Product product = new Product();
        product.setName("Impression, Sunrise");
        product.setReservePrice(300D);
        product.setCode("PMON");
        product.setSeller(participant);
        participant.setProducts(Arrays.asList(product));

        entityManager.persist(participant);
        entityManager.flush();
        entityManager.clear();
    }


    @Test
    @Order(2)
    public void updateParticipant(){
        Product product = entityManager.find(Product.class, 2L);
        Participant participant = product.getSeller();
        participant.setFirstName("Wiilliam");
        participant.getProducts().forEach(prod -> {prod.setCurrency(Currency.USD);});
        entityManager.merge(participant);
        entityManager.flush(); }


    @ParameterizedTest
    @Order(3)
    @ValueSource(longs = {1, 2})
    public void orphanRemoval(long id){
        Product product = entityManager.find(Product.class, id);
        product.setInfo(null);
        entityManager.persist(product);
        entityManager.flush();
    }


}