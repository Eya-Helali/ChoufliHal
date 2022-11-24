package com.example.ChoufliHal.Order;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Order {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)

     private Long orderId;
     private LocalDateTime date;
     private Boolean delivery;
     private Long OrderId;
     private float totalPrice;
     private Payment paymentMethod;




}
