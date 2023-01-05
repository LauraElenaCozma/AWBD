package com.awbd.lab6.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Double reservePrice;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

    @ManyToOne
    private Participant seller;

    @OneToMany(mappedBy = "product")
    private List<Bid> bids;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",
                    referencedColumnName = "id"))
    private List<Category> categories;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    private Boolean restored;

    public void removeCategory(Category category) {
        category.getProducts().remove(this);
        categories.remove(category);
    }
}
