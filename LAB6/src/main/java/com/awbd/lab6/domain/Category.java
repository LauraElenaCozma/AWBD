package com.awbd.lab6.domain;


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

    @ManyToMany(mappedBy = "categories",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Product> products;

    public Category() {
    }

}
