package com.example.ChoufliHal.Order;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
     private Boolean delivery;
     private float totalPrice;
     private Payment paymentMethod;
     @CreationTimestamp
     private LocalDateTime creationDate;
     @UpdateTimestamp
     private LocalDateTime updateDate;
     private LocalDateTime deleteDate;




}
