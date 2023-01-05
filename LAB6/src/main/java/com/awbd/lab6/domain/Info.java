package com.awbd.lab6.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Byte[] imagine;
    private String description;

    @OneToOne
    private Product product;
}
