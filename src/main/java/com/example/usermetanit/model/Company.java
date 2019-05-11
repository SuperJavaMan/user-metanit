package com.example.usermetanit.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "User_Company",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    )
    private Set<User> users = new HashSet<>();
}
