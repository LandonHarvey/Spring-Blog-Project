package com.codeup.springcodeupproject.models;

import javax.persistence.*;

@Entity
@Table(name="orc")
public class Orc {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, length = 100)
    private String imgURL;
    @Column(nullable = false, length = 100)
    private long health = 100;
    @Column(nullable = false, length = 100)
    private long healing = 3;
    @Column(nullable = false, length = 100)
    private long arrows = 50;

}
