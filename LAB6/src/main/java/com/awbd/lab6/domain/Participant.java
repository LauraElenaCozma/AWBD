package com.awbd.lab6.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private java.util.Date birthDate;


    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;


    @OneToMany(mappedBy = "bidder")
    private List<Bid> bids;

}
