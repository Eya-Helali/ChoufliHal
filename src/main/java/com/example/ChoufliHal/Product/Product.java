package com.example.ChoufliHal.Product;

import com.example.ChoufliHal.Order.MyOrder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Product  {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private String name;
    private String price;
    private String description;
    private ProductState state;
    private ProductCategory category;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    @ManyToOne
    private MyOrder myorder;

}
