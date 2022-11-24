package com.example.ChoufliHal.Product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private String name;
    private String price;
    private String description;
    private ProductState state;
    private ProductCategory category;

}
