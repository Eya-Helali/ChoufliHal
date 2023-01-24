package com.example.ChoufliHal.User;

import com.example.ChoufliHal.Order.MyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class User implements UserDetails {

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
    private Boolean locked=true;
    private Boolean enabled=false;
    private String verificationCode;

    @OneToMany(mappedBy="user")
    private List<MyOrder> myOrder;


    public User(String firstName, String lastName,  String username,  Long phoneNumber,Long cin,String address, String password,String verificationCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
        this.password = password;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.verificationCode=verificationCode;
    }





    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+  userRole.name());
        return Collections.singletonList(authority);
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
