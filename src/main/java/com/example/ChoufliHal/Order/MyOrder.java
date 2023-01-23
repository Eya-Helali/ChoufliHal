package com.example.ChoufliHal.Order;

import com.example.ChoufliHal.Product.Product;
import com.example.ChoufliHal.User.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
   public class MyOrder {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long orderId;
     private Boolean delivery;
     private float totalPrice;
     private Payment paymentMethod;
     @CreationTimestamp
     private LocalDateTime creationDate;
     @UpdateTimestamp
     private LocalDateTime updateDate;
     private LocalDateTime deleteDate;

     @ManyToOne
     private User user;

     @OneToMany(mappedBy = "order")
     private List<Product> product;



}
