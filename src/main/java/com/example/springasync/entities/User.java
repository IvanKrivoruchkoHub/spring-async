package com.example.springasync.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public static enum Authority {
        USER, ADMIN
    }
}
