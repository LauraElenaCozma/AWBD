package com.awbd.lab5.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns =@JoinColumn(name="category_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="product_id",referencedColumnName="id"))
    private List<Product> products;

    public Category() {
    }

}
