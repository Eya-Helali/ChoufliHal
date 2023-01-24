package com.example.ChoufliHal.User.LoginAndRegistration;

import lombok.Data;

@Data
public class Registration {
    private String firstName;
    private String lastName;
    private String username;
    private Long phoneNumber;
    private Long cin;
    private String address;
    private String password;
}
