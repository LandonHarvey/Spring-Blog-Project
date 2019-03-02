package com.codeup.springcodeupproject.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="Adventurer")
public class Adventurer {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String imgURL;
    @Column(nullable = false, length = 100)
    private long level = 1;
    @Column(nullable = false, length = 100)
    private long health = 100;
    @Column(nullable = false, length = 100)
    private long healing = 3;
    @Column(nullable = false, length = 100)
    private long arrows = 50;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}