package com.example.ChoufliHal.Order;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
public class MyOrder {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long orderId;
     private LocalDateTime orderDate;
     private Boolean delivery;
     private float totalPrice;
     private Payment paymentMethod;




}
