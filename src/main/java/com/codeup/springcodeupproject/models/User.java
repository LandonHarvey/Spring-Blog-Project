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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
