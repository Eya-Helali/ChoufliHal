package com.example.ChoufliHal.User;

import com.example.ChoufliHal.Order.MyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String password;
    private int evaluation;
    private Long cin;
    private Long phoneNumber;
    private UserRole userRole;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    @OneToMany(mappedBy="user")
    private List<MyOrder> myOrder;

}
