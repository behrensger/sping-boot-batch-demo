package de.openaqua.batchdemo.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long productId;
    @Column(name = "productname")
    private String productName;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "price")
    private BigDecimal price;

    public Product() {

    }

    public Product(Long productId, String productName, Integer stock, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
    }
}