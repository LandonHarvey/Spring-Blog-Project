package com.codeup.springcodeupproject.models;

import javax.persistence.*;


@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true ,nullable = false, length = 100)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
}
