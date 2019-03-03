package com.codeup.springcodeupproject.Entities;

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
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "adventurelog_id")
    private AdventureLog adventureLog;

    public Adventurer(String name, String imgURL, long level, long health, long healing, long arrows, User user,AdventureLog adventureLog){
        this.name = name;
        this.imgURL = imgURL;
        this.level = level;
        this.health = health;
        this.healing = healing;
        this.arrows = arrows;
        this.user = user;
        this.adventureLog = adventureLog;
    }

    public Adventurer (String name, String imgURL, AdventureLog adventureLog){
        this.name = name;
        this.imgURL = imgURL;
        this.adventureLog = adventureLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getHealing() {
        return healing;
    }

    public void setHealing(long healing) {
        this.healing = healing;
    }

    public long getArrows() {
        return arrows;
    }

    public void setArrows(long arrows) {
        this.arrows = arrows;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdventureLog getAdventureLog() {
        return adventureLog;
    }

    public void setAdventureLog(AdventureLog adventureLog) {
        this.adventureLog = adventureLog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}