package com.visa.dynalab.exam;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "persons")
public class Person {
    // ZADANIE 22222
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @Email
    private String email;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;
}
